package tech.eboot.xplanet.base;


import androidx.databinding.ViewDataBinding;

import tech.eboot.xplanet.BR;

/**
 * Created by hl
 * on 2021/6/25.
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends SimpleActivity {

    @Override
    public int initVariableId() {
        return 0;
    }


    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
}