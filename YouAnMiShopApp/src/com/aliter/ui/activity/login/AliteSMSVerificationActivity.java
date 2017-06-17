package com.aliter.ui.activity.login;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.injector.component.AliteSmsVerificationHttpModule;
import com.aliter.injector.component.activity.DaggerAliteSmsVerificationComponent;
import com.aliter.presenter.AliteSmsVerificationPresenter;
import com.aliter.presenter.impl.AliteSmsVerficationPresenterImpl;
import com.blankj.utilcode.utils.StringUtils;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.Constants;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/6.
 */

public class AliteSMSVerificationActivity extends BaseActivity<AliteSmsVerficationPresenterImpl> implements AliteSmsVerificationPresenter.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_clean_phone)
    ImageView btnCleanPhone;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.btn_clean_password)
    ImageView btnCleanPassword;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.tv_phone_num)
    TextView tvPhoneNum;
    @BindView(R.id.tv_verification)
    TextView tvVerification;
    private String PhoneNum;
    private boolean eyeOpen;
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
    protected void onResume() {
        eyeOpen = false;
        super.onResume();
    }

    @Override
    public void setState(int state) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_sms_verification;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar, "");
    }

    @Override
    public void initView() {


        resendTime = 54;
        handler.sendEmptyMessageDelayed(TIME_CHANGE, 1000);
        //  1.  获取验证码

        PhoneNum = PreferUtil.getInstance().getRegisterPhonenum();
        if (!StringUtils.isEmpty(PhoneNum)) {
            if (PhoneNum.length() == 11) {

                AuthCode authCode = new AuthCode();
                authCode.setMobile(PhoneNum);
                authCode.setType(AppController.ShopRigisterLoginType);
                mPresenter.ShopgetSecurityCode(authCode);
            }
        }
        initListener();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerAliteSmsVerificationComponent.builder().aliteSmsVerificationHttpModule(new AliteSmsVerificationHttpModule()).build().injectData(this);
    }

    @OnClick({R.id.btn_clean_phone, R.id.btn_clean_password, R.id.btn_ok,R.id.tv_verification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_phone:

                break;
            case R.id.btn_clean_password:
                if (!eyeOpen) {
                    //  密码明文
                    editPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    editPassword.setSelection(editPassword.getText().length());//将光标移至文字末尾
                    btnCleanPassword.setImageResource(R.drawable.al_login_display);
                    eyeOpen = true;
                } else {
                    editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    editPassword.setSelection(editPassword.getText().length());//将光标移至文字末尾
                    btnCleanPassword.setImageResource(R.drawable.al_login_invisible);
                    eyeOpen = false;
                }
                break;

            case R.id.btn_ok:
                 // 发送验证码到后台验证
                CheckAuthCode checkAuthCode = new CheckAuthCode();
                checkAuthCode.setMobile(PhoneNum);
                checkAuthCode.setCode(editPhone.getText().toString());
                checkAuthCode.setType(AppController.ShopRigisterLoginType);
                mPresenter.ShopAPPCheckSecurityCode(checkAuthCode);
                break;

            case R.id.tv_verification:  // 重新发送验证码
                if (resendTime > 0) {
                    ViewUtils.showToast(resendTime + "秒后才可再次发送");
                } else {

                    //获取验证码
                    AuthCode authCode = new AuthCode();
                    authCode.setMobile(PhoneNum);
                    authCode.setType(AppController.ShopRigisterLoginType);
                    authCode.setUserName(editPhone.getText().toString());
                    mPresenter.ShopgetSecurityCode(authCode);

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
                    btnCleanPhone.setVisibility(View.GONE);
                    btnOk.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnOk.setEnabled(false);
                } else {
                    if (!StringUtil.isNull(editPassword.getText().toString())) {
                        btnOk.setBackgroundResource(R.drawable.alite_btn_login_phone);
                        btnOk.setEnabled(true);
                    } else {
                        btnOk.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnOk.setEnabled(false);
                        btnOk.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                if (temp.length() > 6) {
                    s.delete(6, s.length());
                    editPhone.setText(s);
                    editPhone.setSelection(s.length());
                    ViewUtils.showToast("验证码只能为6位的数字或字母组成");
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
                    btnOk.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnOk.setEnabled(false);
                    btnOk.setTextColor(getResources().getColor(R.color.white));
                } else {
                    btnCleanPassword.setVisibility(View.VISIBLE);
                    if (!StringUtil.isNull(editPhone.getText().toString())) {
                        btnOk.setBackgroundResource(R.drawable.alite_btn_login_phone);
                        btnOk.setEnabled(true);
                    } else {
                        btnOk.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnOk.setEnabled(false);
                        btnOk.setTextColor(getResources().getColor(R.color.white));
                    }
                }
                if (temp.length() > Constants.PASSWORD_MAX_LENGTH) {
                    s.delete(Constants.PASSWORD_MAX_LENGTH, s.length());
                    editPassword.setText(s);
                    editPassword.setSelection(s.length());
                    ViewUtils.showToast("密码只能为6-16位的数字或字母组成");
                }
            }
        });
    }

    @Override
    public void onShopAPPCheckSecurityCodeSuccessView( ) {
        //验证验证码成功
        PreferUtil.getInstance().setRegisterPwd(editPassword.getText().toString());  //保存密码    在注册页面提交到后台
        PreferUtil.getInstance().setRegisterCode(editPhone.getText().toString());    //保存验证码  在注册页面提交到后台
        ViewUtils.startActivity(new Intent(AliteSMSVerificationActivity.this, AliteSettingShopInfoActivity.class), this);
    }

    @Override
    public void onShopgetSecurityCodeSuccessView( ) {
        //发送验证码成功
        ViewUtils.showToast(this.getResources().getString(R.string.sen_register_code));
        resendTime = 54;
        handler.sendEmptyMessageDelayed(TIME_CHANGE, 1000);
        StringBuilder sb = new StringBuilder(PhoneNum);
        sb.replace(3, 7, "****");
        tvPhoneNum.setText("短信验证码已发送至" + " " + sb.toString());
    }

    @Override
    public void onFailView(String errorMsg) {
//        ViewUtils.showToast("验证码发送失败，请重新发送");
    }

}
