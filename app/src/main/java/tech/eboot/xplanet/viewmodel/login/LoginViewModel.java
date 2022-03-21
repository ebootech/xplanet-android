package tech.eboot.xplanet.viewmodel.login;

import android.app.Application;

import org.jetbrains.annotations.NotNull;
import tech.eboot.xplanet.base.BaseViewModel;
import tech.eboot.xplanet.model.BaseRepository;

/**
 * @date 2021.4.16
 *
 */
public class LoginViewModel extends BaseViewModel {

    public LoginViewModel(@NotNull Application application, BaseRepository repository) {
        super(application,repository);

    }
    /**
     * 登录
     * */
    public void login(String phoneNumber, String password) {

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

