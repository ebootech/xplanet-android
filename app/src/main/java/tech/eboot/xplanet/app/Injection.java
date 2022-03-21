package tech.eboot.xplanet.app;

import tech.eboot.xplanet.data.LocalDataSourceImpl;
import tech.eboot.xplanet.model.BaseRepository;
import tech.eboot.xplanet.model.api.HttpDataSourceImpl;
import tech.eboot.xplanet.model.api.RemoteMeetingService;
import tech.eboot.xplanet.model.api.RetrofitServiceManager;
import tech.eboot.xplanet.model.source.HttpDataSource;
import tech.eboot.xplanet.model.source.LocalDataSource;


/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 * Created by goldze on 2019/3/26.
 */
public class Injection {
    public static BaseRepository provideDemoRepository() {
        //网络API服务
        RemoteMeetingService apiService = RetrofitServiceManager.getInstance().create(RemoteMeetingService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return BaseRepository.getInstance(httpDataSource, localDataSource);
    }
}
