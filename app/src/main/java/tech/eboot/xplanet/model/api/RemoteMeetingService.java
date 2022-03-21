package tech.eboot.xplanet.model.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tech.eboot.xplanet.model.BaseResponseBody;
import tech.eboot.xplanet.model.bean.UserBody;

/**
 * @auther Planck
 * @date 2022/2/18
 * @time 16:27.
 */
public interface RemoteMeetingService {

    /**
     * 手机密码登录
     *
     * @param phone           手机号码
     * @param password        密码
     * @return 返回token
     */
    @FormUrlEncoded
    @POST("loginUserPhone.html")
    Observable<BaseResponseBody<UserBody>> loginByPassword(@Field("phone") String phone,
                                                           @Field("password") String password);
}
