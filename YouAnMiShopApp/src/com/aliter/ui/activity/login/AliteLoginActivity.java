package com.aliter.ui.activity.login;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.LoginBean;
import com.aliter.http.BaseResponse;
import com.aliter.presenter.LoginPresenter;
import com.aliter.presenter.impl.LoginPresenterImpl;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/5.
 */

public class AliteLoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.ll_verification_login)
    LinearLayout llVerificationLogin;
    @BindView(R.id.btn_clean_name)
    ImageView btnCleanName;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.btn_clean_password)
    ImageView btnCleanPassword;
    @BindView(R.id.tv_register_shop)
    TextView tvRegisterShop;


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
        setToolBar(toolbar, "");
    }

    @Override
    public void initView() {
        tabLayout.addTab(tabLayout.newTab().setText("密码登陆"));
        tabLayout.addTab(tabLayout.newTab().setText("验证码登陆"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        if (llVerificationLogin.getVisibility() == View.VISIBLE)
                            llVerificationLogin.setVisibility(View.GONE);
                        if (btnCleanName.getVisibility() == View.GONE)
                            btnCleanName.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        if (llVerificationLogin.getVisibility() == View.GONE)
                            llVerificationLogin.setVisibility(View.VISIBLE);
                        if (btnCleanName.getVisibility() == View.VISIBLE)
                            btnCleanName.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }


    @OnClick({R.id.btn_clean_name, R.id.btn_clean_password, R.id.tv_forget_pwd,R.id.tv_register_shop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_name:
                break;
            case R.id.btn_clean_password:
                break;
            case R.id.tv_forget_pwd:
                ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AliteForgetPwdActivity.class), this);

                break;
            case R.id.tv_register_shop:
                ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AlitePhoneRegisterActivity.class), this);

                break;
        }
    }

}
