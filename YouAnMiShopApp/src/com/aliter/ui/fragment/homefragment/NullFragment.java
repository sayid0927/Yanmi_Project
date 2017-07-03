package com.aliter.ui.fragment.homefragment;

import com.aliter.base.BaseFragment;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

public class NullFragment extends BaseFragment  {


    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.null_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {

    }
}
