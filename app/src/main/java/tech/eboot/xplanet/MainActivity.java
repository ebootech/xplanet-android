package tech.eboot.xplanet;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

import tech.eboot.xplanet.app.AppViewModelFactory;
import tech.eboot.xplanet.base.SimpleActivity;
import tech.eboot.xplanet.databinding.ActivityMainBinding;
import tech.eboot.xplanet.ui.me.MeFg;
import tech.eboot.xplanet.ui.message.MessageFragment;
import tech.eboot.xplanet.viewmodel.me.UserCenterViewModel;


public class MainActivity extends SimpleActivity<ActivityMainBinding, UserCenterViewModel> {

    private List<Fragment> fragments = new ArrayList<>();
    private int lastIndex = 0;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public UserCenterViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return new ViewModelProvider(this, factory).get(UserCenterViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();
        initView();
    }

    public void initView(){
        fragments.add(new MessageFragment());
        fragments.add(new MeFg());
        initNav();
    }

    private void initNav() {
        binding.navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_message:
                        setFragmentPosition(0);
                        break;
                    case R.id.navigation_me:
                        setFragmentPosition(1);
                        break;
                }
                return true;
            }
        });
    }
    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = fragments.get(position);
        Fragment lastFragment = fragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.ll_frameLayout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }
}