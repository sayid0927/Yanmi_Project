package com.aliter.ui.activity.login;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.WeixinUserInfoBean;
import com.aliter.injector.component.AliteWeixinUserPhoneHttpModule;
import com.aliter.injector.component.activity.DaggerAliteWeixinUserPhoneComponent;
import com.aliter.presenter.AliteWeixinUserPhonePresenter;
import com.aliter.presenter.impl.AliteWeixinUserPhonePresenterImpl;
import com.aliter.utils.GlideUtils;
import com.blankj.utilcode.utils.StringUtils;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;
import com.zxly.o2o.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by sayid on 2017/6/6.
 */

public class AliteWeixinUserPhoneActivity extends BaseActivity<AliteWeixinUserPhonePresenterImpl> implements AliteWeixinUserPhonePresenter.View {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_user_head)
    CircleImageView imgUserHead;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_clean_password)
    ImageView btnCleanPassword;
    @BindView(R.id.btn_back_pwd)
    Button btnBackPwd;
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.ll_verification_login)
    LinearLayout llVerificationLogin;

    private String iconurl;

    @Override
    public void setState(int state) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_weixin_user_phone;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar, "");
    }

    @Override
    public void initView() {
        btnBackPwd.setEnabled(false);
        btnBackPwd.setTextColor(getResources().getColor(R.color.white));
        initListener();
        WeixinUserInfoBean weixinUserInfo = PreferUtil.getInstance().getWeixinUserInfo();
        if (weixinUserInfo != null) {
            if (!StringUtils.isEmpty(weixinUserInfo.getIconurl())) {
                iconurl = weixinUserInfo.getIconurl();
                GlideUtils.loadMovieTopImg(imgUserHead, iconurl);
            }
            if (!StringUtils.isEmpty(weixinUserInfo.getName()))
                tvUserName.setText(weixinUserInfo.getName());
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerAliteWeixinUserPhoneComponent.builder().aliteWeixinUserPhoneHttpModule(new AliteWeixinUserPhoneHttpModule()).build().injectData(this);
    }

    private void initListener() {
        StringUtil.changeScrollView(editPhone, scrollView);
        StringUtil.changeScrollView(editPassword, scrollView);
        editPhone.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnBackPwd.setEnabled(false);
                    btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                } else {
                    if (!s.toString().startsWith("1")) {
                        editPhone.setText("");
                        ViewUtils.showToast("请输入正确的电话号码！");
                        btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnBackPwd.setEnabled(false);
                        btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        if (!StringUtil.isNull(editPassword.getText().toString())) {
                            btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_phone);
                            btnBackPwd.setEnabled(true);
                        } else {
                            btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                            btnBackPwd.setEnabled(false);
                            btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                        }
                    }
                }
                if (temp.length() > 11) {
                    s.delete(11, s.length());
                    editPhone.setText(s);
                    editPhone.setSelection(s.length());
                }
            }
        });


        editPassword.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    btnCleanPassword.setVisibility(View.GONE);
                    btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnBackPwd.setEnabled(false);
                    btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                } else {
                    btnCleanPassword.setVisibility(View.VISIBLE);
                    if (!StringUtil.isNull(editPhone.getText().toString())) {
                        btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_phone);
                        btnBackPwd.setEnabled(true);
                    } else {
                        btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnBackPwd.setEnabled(false);
                        btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                if (temp.length() > 6) {
                    s.delete(6, s.length());
                    editPassword.setText(s);
                    editPassword.setSelection(s.length());
                    ViewUtils.showToast("验证码只能为6位的数字或字母组成");
                }
            }
        });
    }

    @OnClick({R.id.btn_clean_password, R.id.btn_back_pwd,R.id.ll_verification_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_password:
                editPassword.setText("");
                break;
            case R.id.btn_back_pwd:
                ViewUtils.startActivity(new Intent(AliteWeixinUserPhoneActivity.this, AliteSettingShopInfoActivity.class), this);
                break;
            case R.id.ll_verification_login:
                AuthCode authCode = new AuthCode();
                authCode.setCommand(19);
                authCode.setMobilePhone(editPhone.getText().toString().trim());
                mPresenter.fetchgetAuthCode(authCode);
                break;
        }
    }

    @Override
    public void onAuthCodeSuccessView(AuthCodeBean authCodeBean) {

    }

    @Override
    public void onFailView(String errorMsg) {

    }
}
