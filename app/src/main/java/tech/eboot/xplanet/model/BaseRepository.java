package tech.eboot.xplanet.model;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.reactivex.rxjava3.core.Observable;
import tech.eboot.xplanet.base.BaseModel;
import tech.eboot.xplanet.model.bean.UserBody;
import tech.eboot.xplanet.model.source.HttpDataSource;
import tech.eboot.xplanet.model.source.LocalDataSource;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * @auther Planck
 * @date 2022/2/18
 * @time 16:19.
 */

public class BaseRepository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static BaseRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private BaseRepository(@NonNull HttpDataSource httpDataSource,
                           @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static BaseRepository getInstance(HttpDataSource httpDataSource,
                                             LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (BaseRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<BaseResponseBody<UserBody>> login(String phone, String password) {
        return mHttpDataSource.login(phone,password);
    }


    @Override
    public void saveValue(@NonNull String key, String value) {
        mLocalDataSource.saveValue(key,value);
    }

    @Override
    public String getStringData(@NonNull String key) {
        return mLocalDataSource.getStringData(key);
    }
}
