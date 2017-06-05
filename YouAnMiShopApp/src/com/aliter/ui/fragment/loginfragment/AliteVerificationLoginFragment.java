package com.aliter.ui.fragment.loginfragment;

import com.aliter.base.BaseFragment;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

/**
 * Created by sayid on 2017/6/5.
 */

public class AliteVerificationLoginFragment extends BaseFragment {
    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_verification_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {

    }
}
