package tech.eboot.xplanet.model.source;

import androidx.annotation.NonNull;

import tech.eboot.xplanet.model.bean.UserBody;

/**
 * @auther Planck
 * @date 2022/2/18
 * @time 16:20.
 */
public interface LocalDataSource {

    /**
     *字段保存
     */
    void saveValue(@NonNull final String key, String value);

    String getStringData(@NonNull String key);

}
