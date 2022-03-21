package tech.eboot.xplanet.app;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import tech.eboot.xplanet.base.BaseViewModel;
import tech.eboot.xplanet.model.BaseRepository;
import tech.eboot.xplanet.utils.LogUtils;
import tech.eboot.xplanet.viewmodel.home.MessageViewModel;
import tech.eboot.xplanet.viewmodel.me.UserCenterViewModel;


/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final BaseRepository mRepository;
    BaseViewModel baseViewModel;
    UserCenterViewModel userCenterViewModel;
    MessageViewModel messageViewModel;
    public static AppViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application, Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application, BaseRepository repository) {
        this.mApplication = application;
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        LogUtils.i("initViewModel---modelClass"+ modelClass.getName());
        if (modelClass.isAssignableFrom(BaseViewModel.class)) {
            if (baseViewModel != null) {
                return (T) baseViewModel;
            } else {
                baseViewModel = new BaseViewModel(mApplication, mRepository);
                return (T) baseViewModel;
            }
        }

        if (modelClass.isAssignableFrom(UserCenterViewModel.class)) {
            if (userCenterViewModel != null) {
                return (T) userCenterViewModel;
            } else {
                userCenterViewModel = new UserCenterViewModel(mApplication, mRepository);
                return (T) userCenterViewModel;
            }
        }

        if (modelClass.isAssignableFrom(MessageViewModel.class)) {
            if (messageViewModel != null) {
                return (T) messageViewModel;
            } else {
                messageViewModel = new MessageViewModel(mApplication, mRepository);
                return (T) messageViewModel;
            }
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
