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
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.entity.Login;
import com.aliter.injector.component.LoginHttpModule;
import com.aliter.injector.component.activity.DaggerLoginComponent;
import com.aliter.presenter.LoginPresenter;
import com.aliter.presenter.impl.LoginPresenterImpl;
import com.aliter.ui.activity.AliterHomeActivity;
import com.blankj.utilcode.utils.StringUtils;
import com.easemob.chatuidemo.HXConstant;
import com.easemob.easeui.model.IMUserInfoVO;
import com.orhanobut.logger.Logger;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.application.Config;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.Constants;
import com.zxly.o2o.util.DESUtils;
import com.zxly.o2o.util.EncryptionUtils;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/5.
 */

public class AliteLoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_clean_phone)
    ImageView btnCleanPhone;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.btn_clean_password)
    ImageView btnCleanPassword;
    @BindView(R.id.tv_register_shop)
    TextView tvRegisterShop;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_pwd_login)
    Button btnPwdLogin;
    @BindView(R.id.btn_register_login)
    Button btnRegisterLogin;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.ll_verification_login)
    LinearLayout llVerificationLogin;
    @BindView(R.id.view_pwd_login)
    View viewPwdLogin;
    @BindView(R.id.view_register_login)
    View viewRegisterLogin;
    @BindView(R.id.tv_verification)
    TextView tvVerification;
    private String TAG = AliteLoginActivity.class.getName();
    private String password, phoneNumber;
    private int LoginType = 0;    //0 密码登录  1 验证码登录
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
    public void onLoginSuccessView(IMUserInfoVO usserInfo) {
        Logger.t(TAG).d("登录成功返回信息  ==  " + usserInfo);
        if (!StringUtils.isEmpty(usserInfo.getSignKey())) {
            try {
                Config.accessKey = DESUtils.decrypt(usserInfo.getSignKey(), Config.USER_SIGN_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isEmpty(usserInfo.getToken()))
            PreferUtil.getInstance().setLoginToken(usserInfo.getToken());
        HXConstant.isLoginSuccess = true; //标识登录hx成功

        AppController.getInstance().initHXAccount(usserInfo, true);   //登录环信
        usserInfo.setPassword(EncryptionUtils.md5TransferPwd(password));
        usserInfo.setUserName(phoneNumber);
        Account.saveLoginUser(this, usserInfo);
        Account.user = usserInfo;

        ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AliterHomeActivity.class), this);
    }

    @Override
    public void onAuthCodeSuccessView(AuthCodeBean authCodeBean) {
        Logger.t(TAG).d("成功获取验证码返回信息  ==  " + authCodeBean);
        ViewUtils.showToast("验证码已发送");
    }

    @Override
    public void onCheckAuthCodeSuccessView(CheckAuthCodeBean checkAuthCodeBean) {
        Logger.t(TAG).d("成功验证验证码返回信息  ==  " + checkAuthCodeBean);
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
        initListener();
        editPhone.setText("13592495216");
        editPassword.setText("123456");
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerLoginComponent.builder().loginHttpModule(new LoginHttpModule()).build().injectWeChat(this);
    }


    @OnClick({R.id.btn_clean_phone, R.id.btn_clean_password, R.id.tv_forget_pwd, R.id.tv_register_shop, R.id.btn_login,
            R.id.btn_pwd_login, R.id.btn_register_login, R.id.ll_verification_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_phone:
                editPhone.setText("");
                break;
            case R.id.btn_clean_password:
                editPassword.setText("");
                break;
            case R.id.tv_forget_pwd:
                ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AliteForgetPwdActivity.class), this);

                break;
            case R.id.tv_register_shop:
                ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AlitePhoneRegisterActivity.class), this);

                break;
            case R.id.btn_login:

                phoneNumber = editPhone.getText().toString();
                password = editPassword.getText().toString();

                if ("13888888888".equals(phoneNumber) && "yam2017".equals(password)) {
                    ViewUtils.showLongToast(StringUtil.getCheckInfo());
                    return;
                }
                Pattern pp = Pattern.compile(Constants.PHONE_PATTERN);
                Matcher pm = pp.matcher(phoneNumber);
                if (!pm.matches()) {
                    ViewUtils.showToast("请输入正确的电话号码！");
                    return;
                }
                Pattern p = Pattern.compile(Constants.PASSWORD_PATTERN);
                Matcher m = p.matcher(password);
                if (!m.matches()) {
                    ViewUtils.showToast("密码只能为6-16位的数字或字母组成");
                    return;
                }
                if (LoginType == 0) {
                    //密码登录
                    Login login = new Login();
                    login.setClientId(Config.getuiClientId);
                    login.setUserName(phoneNumber);
                    login.setPassword(EncryptionUtils.md5TransferPwd(password));
                    mPresenter.fetchLogin(login);
                } else {
                    //  手机验证码登录
                    Login login = new Login();
                    login.setClientId(Config.getuiClientId);
                    login.setUserName(phoneNumber);
                    login.setType(AppController.PhoneRigisterLoginType);
                    login.setCode(editPassword.getText().toString());
                    mPresenter.fetchLogin(login);

                }
                break;
            case R.id.btn_pwd_login:
                if (llVerificationLogin.getVisibility() == View.VISIBLE)
                    llVerificationLogin.setVisibility(View.GONE);

                if (!StringUtils.isEmpty(editPhone.getText().toString()))
                    btnCleanPhone.setVisibility(View.VISIBLE);
                else
                    btnCleanPhone.setVisibility(View.GONE);
                if (!StringUtils.isEmpty(editPassword.getText().toString()))
                    btnCleanPassword.setVisibility(View.VISIBLE);

                else
                    btnCleanPassword.setVisibility(View.GONE);

                viewRegisterLogin.setVisibility(View.GONE);
                viewPwdLogin.setVisibility(View.VISIBLE);
                btnRegisterLogin.setTextColor(this.getResources().getColor(R.color.gray_999999));
                btnPwdLogin.setTextColor(this.getResources().getColor(R.color.orange_ff903e));
                LoginType = 0;
                break;
            case R.id.btn_register_login:
                if (llVerificationLogin.getVisibility() == View.GONE)
                    llVerificationLogin.setVisibility(View.VISIBLE);

                if (btnCleanPhone.getVisibility() == View.VISIBLE)
                    btnCleanPhone.setVisibility(View.GONE);

                if (!StringUtils.isEmpty(editPassword.getText().toString()))
                    btnCleanPassword.setVisibility(View.VISIBLE);
                else
                    btnCleanPassword.setVisibility(View.GONE);

                viewRegisterLogin.setVisibility(View.VISIBLE);
                viewPwdLogin.setVisibility(View.GONE);
                btnRegisterLogin.setTextColor(this.getResources().getColor(R.color.orange_ff903e));
                btnPwdLogin.setTextColor(this.getResources().getColor(R.color.gray_999999));
                LoginType = 1;
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
                    authCode.setType(AppController.PhoneRigisterLoginType);
                    authCode.setUserName(editPhone.getText().toString());
                    mPresenter.fetchgetAuthCode(authCode);

                }
                break;
        }

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
                    btnCleanPhone.setVisibility(View.GONE);
                    btnLogin.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnLogin.setEnabled(false);
                } else {
                    if (!s.toString().startsWith("1")) {
                        editPhone.setText("");
                        ViewUtils.showToast("请输入正确的电话号码！");
                        btnCleanPhone.setVisibility(View.GONE);
                        btnLogin.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnLogin.setEnabled(false);
                        btnLogin.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        if (LoginType == 0)
                            btnCleanPhone.setVisibility(View.VISIBLE);
                        else
                            btnCleanPhone.setVisibility(View.GONE);
                        if (!StringUtil.isNull(editPassword.getText().toString())) {
                            btnLogin.setBackgroundResource(R.drawable.alite_btn_login_phone);
                            btnLogin.setEnabled(true);
                        } else {
                            btnLogin.setBackgroundResource(R.drawable.alite_btn_login_default);
                            btnLogin.setEnabled(false);
                            btnLogin.setTextColor(getResources().getColor(R.color.white));
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
                    btnLogin.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnLogin.setEnabled(false);
                    btnLogin.setTextColor(getResources().getColor(R.color.white));
                } else {
                    btnCleanPassword.setVisibility(View.VISIBLE);
                    if (!StringUtil.isNull(editPhone.getText().toString())) {
                        btnLogin.setBackgroundResource(R.drawable.alite_btn_login_phone);
                        btnLogin.setEnabled(true);
                    } else {
                        btnLogin.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnLogin.setEnabled(false);
                        btnLogin.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                if (temp.length() > Constants.PASSWORD_MAX_LENGTH) {
                    s.delete(Constants.PASSWORD_MAX_LENGTH, s.length());
                    editPassword.setText(s);
                    editPassword.setSelection(s.length());
                    if (LoginType == 0)
                        ViewUtils.showToast("密码只能为6-16位的数字或字母组成");
                    else
                        ViewUtils.showToast("验证码只能为6-16位的数字或字母组成");
                }
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        handler.removeMessages(TIME_CHANGE);
    }
}
