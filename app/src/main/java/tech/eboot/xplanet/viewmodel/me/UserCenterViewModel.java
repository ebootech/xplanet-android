package tech.eboot.xplanet.viewmodel.me;

import android.app.Application;

import androidx.annotation.NonNull;

import tech.eboot.xplanet.base.BaseViewModel;
import tech.eboot.xplanet.model.BaseRepository;

/**
 * @auther Planck
 * @date 2022/2/24
 * @time 16:48.
 */
public class UserCenterViewModel extends BaseViewModel {

    public UserCenterViewModel(@NonNull Application application, BaseRepository model) {
        super(application, model);
    }
}
