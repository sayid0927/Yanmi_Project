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
import com.aliter.injector.component.LoginHttpModule;
import com.aliter.injector.component.activity.DaggerLoginComponent;
import com.aliter.presenter.LoginPresenter;
import com.aliter.presenter.impl.LoginPresenterImpl;
import com.aliter.ui.activity.AliterHomeActivity;
import com.blankj.utilcode.utils.StringUtils;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.application.Config;
import com.zxly.o2o.request.BaseRequest;
import com.zxly.o2o.request.GeShopAppMenuRequest;
import com.zxly.o2o.request.GetuiBindRequest;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.Constants;
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
                        tvVerification.setText(String.format("重新发送 (%d s) ", resendTime));
                        handler.sendEmptyMessageDelayed(TIME_CHANGE, 1000);
                    } else {
                        ViewUtils.setText(tvVerification, "重新发送");
                    }
                    break;
            }
        }
    };



    @Override
    public void onAuthShopLogin2SuccessView(IMUserInfoVO usserInfo) {
        //  登录成功返回
        Account.saveLoginUser(this, usserInfo);
        Account.user = usserInfo;

        PreferUtil.getInstance().setLoginPhoneNum(editPhone.getText().toString());
        new GetuiBindRequest(Config.getuiClientId).start();
        getShopAppMenu();

    }

    @Override
    public void onShopGetSecurityCodeSuccessView() {
        //  获取验证码成功返回
       DismissLoadingDialog();
        //开启计时功能
        ViewUtils.showToast(this.getResources().getString(R.string.sen_register_code));
        resendTime = 54;
        handler.sendEmptyMessageDelayed(TIME_CHANGE, 1000);
    }

    @Override
    public void onFailView(String errorMsg) {
        DismissLoadingDialog();
    }

    @Override
    public String getUsername() {
        return editPhone.getText().toString();
    }

    @Override
    public String getPassword() {
        return editPassword.getText().toString();
    }

    @Override
    public int getLoginType() {
        return LoginType;
    }

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_login;
    }

    @Override
    public void setToolBar() {

        setToolBar(toolbar, "");
        toolbar.setNavigationIcon(this.getResources().getDrawable(R.drawable.al_login_return));

    }

    @Override
    public void initView() {

        initListener();
        if(StringUtil.isNull(PreferUtil.getInstance().getLoginPhoneNum()));
        editPhone.setText(PreferUtil.getInstance().getLoginPhoneNum());
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
            case R.id.tv_forget_pwd:        //  忘记密码
                Intent intent = new Intent(AliteLoginActivity.this, AliteForgetPwdActivity.class);
                AliteLoginActivity.this.startActivityForResult(intent, 1);
                startActivityIn();

                break;
            case R.id.tv_register_shop:    // 注册商户
                ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AlitePhoneRegisterActivity.class), this);

                break;
            case R.id.btn_login:    //   登录


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
                mPresenter.AuthShopLogin2();
                ShowLoadingDialog();

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
                if(editPassword.getText().length()!=0)
                    editPassword.setText("");
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

            case R.id.ll_verification_login:        //获取验证码
                if (editPhone.getText().length() < 11) {
                    ViewUtils.showToast("请输入正确的手机号");
                    break;
                }
                if (resendTime > 0) {
                    ViewUtils.showToast(resendTime + "秒后才可再次发送");
                } else {
                    //获取验证码
                    mPresenter.ShopGetSecurityCode();
                    ShowLoadingDialog();
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



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (data != null) {
                if (resultCode == 0) { // 忘记密码返回
                    editPhone.setText(data.getStringExtra("phoneNum"));
                }
            }
        }
    }



    private void getShopAppMenu() {
        final GeShopAppMenuRequest geShopAppMenuRequest = new GeShopAppMenuRequest();
        geShopAppMenuRequest.setOnResponseStateListener(new BaseRequest.ResponseStateListener() {
            @Override
            public void onOK() {
                DismissLoadingDialog();
                ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AliterHomeActivity.class), AliteLoginActivity.this);
            }
            @Override
            public void onFail(int code) {
            }
        });
        geShopAppMenuRequest.start();
    }
}
