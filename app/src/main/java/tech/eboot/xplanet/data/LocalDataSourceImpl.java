package tech.eboot.xplanet.data;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.SPUtils;

import tech.eboot.xplanet.model.source.LocalDataSource;
/**
 * @auther Planck
 * @date 2022/2/18
 * @time 16:34.
 */
public class LocalDataSourceImpl implements LocalDataSource {


   /* public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }*/

    private LocalDataSourceImpl() {
    }

    /**
     * 初始化
     * */
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void saveValue(@NonNull String key, String value) {
        SPUtils.getInstance().put(key,value);
    }

    @Override
    public String getStringData(@NonNull String key) {
        return SPUtils.getInstance().getString(key);
    }
}
