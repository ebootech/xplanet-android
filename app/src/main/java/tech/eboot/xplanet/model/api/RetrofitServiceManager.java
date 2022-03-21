package tech.eboot.xplanet.model.api;


import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.eboot.xplanet.BuildConfig;
import tech.eboot.xplanet.utils.LogUtils;

/**
 */
public class RetrofitServiceManager {
    private static final int DEFAULT_CONNECT_TIME = 10;
    private static final int DEFAULT_WRITE_TIME = 30;
    private static final int DEFAULT_READ_TIME = 30;
    private final Retrofit retrofit;

    private RetrofitServiceManager() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        /*if (BaseConstant.isTest) {
            builder.addInterceptor(new LoggingInterceptor());
        }*/
        /*if (!SystemUtil.isNetworkConnected()) {
            ToastUtils.showShort(R.string.warning_no_network);
        }*/
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //连接超时时间
                .connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)
                //设置写操作超时时间
                .writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())//日志打印
                //设置读操作超时时间
                .readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                // TODO: 2021/4/22 目前服务器暂不支持加密传输
                .connectionSpecs(Arrays.asList(ConnectionSpec.COMPATIBLE_TLS,ConnectionSpec.CLEARTEXT))
                // TODO: 2021/5/13 调试服务器临时添加
                .hostnameVerifier(new AllowAllHostnameVerifier())
                .build();

        retrofit = new Retrofit.Builder()
                //设置使用okhttp网络请求
                .client(okHttpClient)
                //设置服务器路径
                .baseUrl(BuildConfig.DEBUG ? BuildConfig.BASE_URL_DEBUG :BuildConfig.BASE_URL)
                //添加转化库，默认是Gson
                .addConverterFactory(GsonConverterFactory.create())
                //添加回调库，采用RxJava
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

    }

    class LoggingInterceptor implements Interceptor {
        private final Charset UTF8 = Charset.forName("UTF-8");

        @Override
        public Response intercept(Chain chain) throws IOException {
            LogUtils.i("AppendHeaderParamIntercepter-------1");
            Request request = chain.request();
            RequestBody requestBody = request.body();

            String body = null;

            if (requestBody != null) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);

                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }
                body = buffer.readString(charset);
            }

            LogUtils.i(String.format("\n发送请求\nmethod：%s\nurl：%s\nheaders: %sbody：%s",
                    request.method(), request.url(), request.headers(), body));

            long startNs = System.nanoTime();
            Response response = chain.proceed(request);
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

            ResponseBody responseBody = response.body();
            String rBody;

            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(UTF8);
                } catch (UnsupportedCharsetException e) {
                    e.printStackTrace();
                }
            }
            rBody = buffer.clone().readString(charset);

            LogUtils.i(String.format("收到响应 %s%s %sms\n请求url：%s\n请求body：%s\n响应body：%s",
                    response.code(), response.message(), tookMs, response.request().url(), body, rBody));
            return response;
        }
    }


    private static class SingletonHolder {
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    /**
     *
     * @return 获取RetrofitServiceManager
     */
    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}
