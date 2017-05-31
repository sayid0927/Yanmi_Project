package com.aliter.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.base.BaseFragmentPageAdapter;
import com.aliter.entity.Login;
import com.aliter.ui.fragment.StoreArticlesFragmentAlite;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.EncryptionUtils;

import java.util.ArrayList;

import butterknife.BindView;

public class AliterHomeActivity extends BaseActivity{

    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_gank)
    TabLayout tabGank;

    private String TAG = AliterHomeActivity.class.getName();
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;

    @Override
    public void setState(int state) {
    }

//    @Override
//    public void onSuccessView(BaseResponse<LoginBean> mData) {
//        Logger.t(TAG).d(mData);
//    }
//
//    @Override
//    public void onFailView(String errorMsg) {
//
//    }

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_home;
    }

    @Override
    public void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvToolbar.setText("首页");
    }

    @Override
    public void initView() {
        initFragmentList();
        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        vpHome.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabGank.setTabMode(TabLayout.MODE_FIXED);
        tabGank.setupWithViewPager(vpHome);
    }

    @Override
    protected void loadData() {
        Login login = new Login();
        login.setClientId("");
        login.setUserName("13113639501");
        login.setPassword(EncryptionUtils.md5TransferPwd("123456"));
//        mPresenter.fetchLogin(login);
    }

    @Override
    protected void initInject() {
//        DaggerLoginComponent.builder().loginHttpModule(new LoginHttpModule()).build().injectLogin(this);
    }

    private void initFragmentList() {

        if (mTitleList.size() != 0) {
            return;
        }

        mTitleList.add("知乎日报");
        mTitleList.add("头条新闻");
        mTitleList.add("排行榜");
        mTitleList.add("最新电影");

        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
        mFragments.add(new StoreArticlesFragmentAlite());
    }
}
