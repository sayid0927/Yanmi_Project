package com.aliter.ui.activity.login;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.injector.component.AliteForgetPwdHttpModule;
import com.aliter.injector.component.activity.DaggerAliteForgetPwdComponent;
import com.aliter.presenter.AliteForgetPwdPresenter;
import com.aliter.presenter.impl.AliteForgetPwdPresenterImpl;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/6.
 */

public class AliteForgetPwdActivity extends BaseActivity<AliteForgetPwdPresenterImpl> implements AliteForgetPwdPresenter.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.btn_clean_password)
    ImageView btnCleanPassword;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_back_pwd)
    Button btnBackPwd;
    @BindView(R.id.ll_verification_login)
    LinearLayout llVerificationLogin;
    @BindView(R.id.tv_verification)
    TextView tvVerification;

    private int resendTime = 0;
    private final int TIME_CHANGE = 100;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TIME_CHANGE:
                    resendTime--;
                    if (resendTime > 0) {
                        tvVerification.setText(String.format("%d秒后重发", resendTime));
                        handler.sendEmptyMessageDelayed(TIME_CHANGE, 1000);
                    } else {
                        ViewUtils.setText(tvVerification, "重新发送");
                    }
                    break;
            }
        }
    };

    @Override
    public void setState(int state) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_forget_pwd;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar, "");
        tvToolbar.setTextColor(this.getResources().getColor(R.color.black));
        tvToolbar.setText("找回密码");
    }

    @Override
    public void initView() {
        btnBackPwd.setEnabled(false);
        btnBackPwd.setTextColor(getResources().getColor(R.color.white));
        initListener();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

        DaggerAliteForgetPwdComponent.builder().aliteForgetPwdHttpModule(new AliteForgetPwdHttpModule()).build().injectData(this);
    }


    @OnClick({R.id.btn_clean_password, R.id.btn_back_pwd, R.id.ll_verification_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_password:
                editPassword.setText("");
                break;
            case R.id.btn_back_pwd:

                CheckAuthCode checkAuthCode = new CheckAuthCode();
                checkAuthCode.setCode(editPassword.getText().toString());
                checkAuthCode.setMobile(editPhone.getText().toString());
                checkAuthCode.setType(18);
                mPresenter.fetchCheckAuthCode(checkAuthCode);
                ViewUtils.startActivity(new Intent(AliteForgetPwdActivity.this, AliteChangePwdActivity.class), this);
                break;
            case R.id.ll_verification_login:

                if (resendTime > 0) {
                    ViewUtils.showToast(resendTime + "秒后才可再次发送");
                } else {
                    resendTime = 54;
                    handler.sendEmptyMessageDelayed(TIME_CHANGE, 1000);
                    //获取验证码
                    AuthCode authCode = new AuthCode();
                    authCode.setMobile(editPhone.getText().toString());
                    authCode.setType(AppController.ForgetPwdType);
                    authCode.setUserName(editPhone.getText().toString());
                    mPresenter.fetchgetAuthCode(authCode);

                }

                break;

        }
    }

    @Override
    public void finish() {
        super.finish();
        handler.removeMessages(TIME_CHANGE);
    }

    private void initListener() {
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


    @Override
    public void onAuthCodeSuccessView(AuthCodeBean forgetPwdAuthCodeBean) {
        ViewUtils.showToast("验证码已发送");
    }

    @Override
    public void onBackPwdSuccessView(CheckAuthCodeBean checkAuthCodeBean) {
        ViewUtils.showToast("验证码成功");
        ViewUtils.startActivity(new Intent(AliteForgetPwdActivity.this, AliteChangePwdActivity.class), this);


    }

    @Override
    public void onFailView(String errorMsg) {

    }
}
