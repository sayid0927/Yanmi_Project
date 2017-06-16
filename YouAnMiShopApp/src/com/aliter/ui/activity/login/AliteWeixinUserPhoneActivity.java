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
import android.widget.ScrollView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.Login;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.entity.WeixinUserInfoBean;
import com.aliter.injector.component.AliteWeixinUserPhoneHttpModule;
import com.aliter.injector.component.activity.DaggerAliteWeixinUserPhoneComponent;
import com.aliter.presenter.AliteWeixinUserPhonePresenter;
import com.aliter.presenter.impl.AliteWeixinUserPhonePresenterImpl;
import com.aliter.ui.activity.AliterHomeActivity;
import com.aliter.utils.GlideUtils;
import com.blankj.utilcode.utils.StringUtils;
import com.easemob.chatuidemo.HXConstant;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.application.Config;
import com.zxly.o2o.dialog.LoadingDialog;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.DESUtils;
import com.zxly.o2o.util.EncryptionUtils;
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
    @BindView(R.id.tv_verification)
    TextView tvVerification;

    private String iconurl;

    private int resendTime = 0;
    private final int TIME_CHANGE = 100;
    private WeixinUserInfoBean weixinUserInfo;

    private LoadingDialog loadingDialog;

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
        weixinUserInfo = PreferUtil.getInstance().getWeixinUserInfo();
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
        loadingDialog = new LoadingDialog(this);
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

    @OnClick({R.id.btn_clean_password, R.id.btn_back_pwd, R.id.ll_verification_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_password:
                editPassword.setText("");
                break;
            case R.id.btn_back_pwd:

                //  2. 验证验证码
                CheckAuthCode checkAuthCode = new CheckAuthCode();
                checkAuthCode.setType(AppController.WeiXinLoginType);
                checkAuthCode.setMobile(editPhone.getText().toString());
                checkAuthCode.setCode(editPassword.getText().toString());
                mPresenter.ShopAPPCheckSecurityCode(checkAuthCode);
                loadingDialog.show();

                break;
            case R.id.ll_verification_login:

                if (resendTime > 0) {
                    ViewUtils.showToast(resendTime + "秒后才可再次发送");
                } else {
                    // 1. 获取验证码
                    AuthCode authCode = new AuthCode();
                    authCode.setMobile(editPhone.getText().toString());
                    authCode.setType(AppController.WeiXinLoginType);
                    mPresenter.ShopGetSecurityCod(authCode);
                    loadingDialog.show();
                }
                break;
        }
    }


    @Override
    public void onShopGetSecurityCodeSuccessView() {
        //  获取验证码成功
        ViewUtils.showToast("获取验证码成功");
        //开启计时功能
        resendTime = 54;
        handler.sendEmptyMessageDelayed(TIME_CHANGE, 1000);
    }

    @Override
    public void onShopAPPCheckSecurityCodeSuccessView() {
        //  验证验证码成功

        ViewUtils.showToast("验证验证码成功");
        //  3. 查询该手机号是否注册过
        MobileExist mobileExist = new MobileExist();
        mobileExist.setMobile(editPhone.getText().toString());
        mPresenter.ShopAppisMobileExist(mobileExist);
    }

    @Override
    public void onShopAppisMobileExistSuccessView(MobileExistBean mobileExistBean) {
        //  查询手机号是否注册过成功
        if (mobileExistBean.isExist()) {
            //如果是老用户直接走验证码登录流程
//            clientId	个推客户端id	string
//            code	验证码	string	type为3，必传，店店推项目增加
//            password	用户密码	string	type为1，必传
//            type	登录类型,1:账号密码登录,2:微信登录,3:验证码登录	number	不传服务器默认为1，店店推项目增加
//            userName	用户账号	string	type为1、3，必传
//            wxOpenId	微信用户openId	string	type为2，必传，店店推项目增加
//            wxUnionId	微信用户统一id	string	type为2，必传，店店推项目增加
            Login login = new Login();
            login.setClientId(Config.getuiClientId);
            login.setCode(editPassword.getText().toString());
            login.setType(3);
            login.setUserName(editPhone.getText().toString());
            login.setWxOpenId(weixinUserInfo.getOpenid());
            login.setWxUnionId(weixinUserInfo.getUnionid());
            mPresenter.AuthShopLogin2(login);

        } else {
            if(loadingDialog.isShow())
                loadingDialog.dismiss();
            // 未注册过  走商户注册流程
            ViewUtils.startActivity(new Intent(AliteWeixinUserPhoneActivity.this, AliteSettingShopInfoActivity.class), this);
        }
    }

    @Override
    public void onAuthShopLogin2SuccessView(IMUserInfoVO usserInfo) {
        //  微信老用户登录成功
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
        usserInfo.setPassword(EncryptionUtils.md5TransferPwd(usserInfo.getPassword()));
        usserInfo.setUserName(usserInfo.getName());

        Account.saveLoginUser(this, usserInfo);
        Account.user = usserInfo;
        if (loadingDialog.isShow())
            loadingDialog.dismiss();
        ViewUtils.startActivity(new Intent(AliteWeixinUserPhoneActivity.this, AliterHomeActivity.class), this);
    }

    @Override
    public void onFailView(String errorMsg) {

    }


    @Override
    public void finish() {
        super.finish();
        handler.removeMessages(TIME_CHANGE);
    }
}
