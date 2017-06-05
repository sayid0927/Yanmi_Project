package com.aliter.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.base.BaseFragmentPageAdapter;
import com.aliter.entity.LoginBean;
import com.aliter.http.BaseResponse;
import com.aliter.presenter.LoginPresenter;
import com.aliter.presenter.impl.LoginPresenterImpl;
import com.aliter.ui.fragment.loginfragment.AlitePhoneLoginFragment;
import com.aliter.ui.fragment.loginfragment.AliteVerificationLoginFragment;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by sayid on 2017/6/5.
 */

public class AliteLoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;


    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;



    @Override
    public void setState(int state) {

    }

    @Override
    public void onSuccessView(BaseResponse<LoginBean> mData) {

    }

    @Override
    public void onFailView(String errorMsg) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_login;
    }

    @Override
    public void setToolBar() {

        setToolBar(toolbar,"");
    }

    @Override
    public void initView() {

        initFragmentList();
        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(vp);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }

    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("密码登录");
        mTitleList.add("验证码登录");
        mFragments.add(new AlitePhoneLoginFragment());
        mFragments.add(new AliteVerificationLoginFragment());

    }

}
