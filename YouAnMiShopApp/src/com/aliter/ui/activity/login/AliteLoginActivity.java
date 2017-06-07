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
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.LoginBean;
import com.aliter.http.BaseResponse;
import com.aliter.presenter.LoginPresenter;
import com.aliter.presenter.impl.LoginPresenterImpl;
import com.aliter.ui.activity.AliterHomeActivity;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.Constants;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/5.
 */

public class AliteLoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_verification_login)
    LinearLayout llVerificationLogin;
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
        initListener();
    }






    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }


    @OnClick({R.id.btn_clean_phone, R.id.btn_clean_password, R.id.tv_forget_pwd, R.id.tv_register_shop, R.id.btn_login,
            R.id.btn_pwd_login, R.id.btn_register_login})
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
                ViewUtils.startActivity(new Intent(AliteLoginActivity.this, AliterHomeActivity.class), this);

                break;
            case R.id.btn_pwd_login:
                if (llVerificationLogin.getVisibility() == View.VISIBLE)
                    llVerificationLogin.setVisibility(View.GONE);
                if (btnCleanPhone.getVisibility() == View.GONE)
                    btnCleanPhone.setVisibility(View.VISIBLE);

                break;
            case R.id.btn_register_login:
                if (llVerificationLogin.getVisibility() == View.GONE)
                    llVerificationLogin.setVisibility(View.VISIBLE);
                if (btnCleanPhone.getVisibility() == View.VISIBLE)
                    btnCleanPhone.setVisibility(View.GONE);
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
                    } else {
                        btnCleanPhone.setVisibility(View.VISIBLE);
                        if (!StringUtil.isNull(editPassword.getText().toString())) {
                            btnLogin.setBackgroundResource(R.drawable.alite_btn_login_phone);
                            btnLogin.setEnabled(true);
                        } else {
                            btnLogin.setBackgroundResource(R.drawable.alite_btn_login_default);
                            btnLogin.setEnabled(false);
                        }
                    }
                }if (temp.length() > 11) {
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
                } else {
                    btnCleanPassword.setVisibility(View.VISIBLE);
                    if (!StringUtil.isNull(editPhone.getText().toString())) {
                        btnLogin.setBackgroundResource(R.drawable.alite_btn_login_phone);
                        btnLogin.setEnabled(true);
                    } else {
                        btnLogin.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnLogin.setEnabled(false);
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

}
