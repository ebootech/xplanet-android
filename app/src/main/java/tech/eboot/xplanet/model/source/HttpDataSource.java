package tech.eboot.xplanet.model.source;


import io.reactivex.rxjava3.core.Observable;
import tech.eboot.xplanet.model.BaseResponseBody;
import tech.eboot.xplanet.model.bean.UserBody;

/**
 * @auther Planck
 * @date 2022/2/18
 * @time 16:19.
 */
public interface HttpDataSource {
    //模拟登录
    Observable<BaseResponseBody<UserBody>> login(String phone, String password);
}
