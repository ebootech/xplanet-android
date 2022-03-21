package tech.eboot.xplanet.viewmodel.home;

import android.app.Application;

import androidx.annotation.NonNull;

import tech.eboot.xplanet.base.BaseViewModel;
import tech.eboot.xplanet.model.BaseRepository;

/**
 * @auther Planck
 * @date 2022/2/24
 * @time 16:48.
 */
public class MessageViewModel extends BaseViewModel {

    public MessageViewModel(@NonNull Application application, BaseRepository model) {
        super(application, model);
    }
}
