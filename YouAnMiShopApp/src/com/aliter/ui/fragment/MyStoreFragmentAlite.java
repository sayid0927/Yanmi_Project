package com.aliter.ui.fragment;


import com.aliter.base.BaseFragment;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

public class MyStoreFragmentAlite extends BaseFragment {


    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_my_store;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {

    }
}
