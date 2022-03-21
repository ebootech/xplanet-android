package tech.eboot.xplanet.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import tech.eboot.xplanet.R;
import tech.eboot.xplanet.base.BaseFragment;
import tech.eboot.xplanet.databinding.FragmentMessageBinding;
import tech.eboot.xplanet.viewmodel.home.MessageViewModel;

/**
 * @auther Planck
 * @date 2022/2/25
 * @time 11:37.
 */
public class MessageFragment extends BaseFragment<FragmentMessageBinding, MessageViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_message;
    }
}
