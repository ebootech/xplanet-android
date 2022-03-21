package tech.eboot.xplanet.model.api;

import io.reactivex.rxjava3.core.Observable;
import tech.eboot.xplanet.model.BaseResponseBody;
import tech.eboot.xplanet.model.bean.UserBody;
import tech.eboot.xplanet.model.source.HttpDataSource;

/**
 * @auther Planck
 * @date 2022/2/18
 * @time 16:26.
 */
public class HttpDataSourceImpl implements HttpDataSource {
    private RemoteMeetingService apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance(RemoteMeetingService apiService) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HttpDataSourceImpl(RemoteMeetingService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<BaseResponseBody<UserBody>> login(String phone, String password) {
        return apiService.loginByPassword(phone,password);
    }
}
