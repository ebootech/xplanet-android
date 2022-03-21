package tech.eboot.xplanet.base;

import android.app.Application;
import androidx.annotation.NonNull;
import tech.eboot.xplanet.model.BaseRepository;


/**
 * Created by goldze on 2017/6/15.
 */
public class BaseViewModel extends SimpleViewModel<BaseRepository>{

    public BaseViewModel(@NonNull Application application, BaseRepository model) {
        super(application, model);
    }


}
