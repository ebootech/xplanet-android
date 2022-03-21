package tech.eboot.xplanet.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import tech.eboot.xplanet.BR;
import tech.eboot.xplanet.R;

/**
 * Created by hl
 * on 2021/6/25.
 */
public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends SimpleFragment {
    @Override
    public int initVariableId() {
        return BR._all;
    }
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_me;
    }

    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    //public abstract int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}