package tech.eboot.xplanet.ui.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import tech.eboot.xplanet.R;
import tech.eboot.xplanet.app.AppViewModelFactory;
import tech.eboot.xplanet.base.BaseFragment;
import tech.eboot.xplanet.databinding.FragmentMeBinding;
import tech.eboot.xplanet.viewmodel.me.UserCenterViewModel;

/**
 * @auther Planck
 * @date 2022/2/25
 * @time 11:57.
 */
public class MeFg extends BaseFragment<FragmentMeBinding, UserCenterViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_me;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
