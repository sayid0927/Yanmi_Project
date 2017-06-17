package com.aliter.ui.activity.login;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.Login;
import com.aliter.injector.component.LaunchHttpModule;
import com.aliter.injector.component.activity.DaggerLaunchComponent;
import com.aliter.presenter.LaunchPresenter;
import com.aliter.presenter.impl.LaunchPresenterImpl;
import com.aliter.ui.activity.AliterHomeActivity;
import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.StringUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.easemob.chatuidemo.HXConstant;
import com.easemob.easeui.model.IMUserInfoVO;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.application.Config;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.DESUtils;
import com.zxly.o2o.util.EncryptionUtils;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN;

/**
 * Created by sayid on 2017/6/5.
 */

public class AliteLaunchActivity extends BaseActivity<LaunchPresenterImpl> implements LaunchPresenter.View {


    @BindView(R.id.layout_phone_login)
    RelativeLayout layoutPhoneLogin;
    @BindView(R.id.layout_wchat_login)
    RelativeLayout layoutWchatLogin;
    @BindView(R.id.registered_shop_account)
    TextView registeredShopAccount;


    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_launch;
    }

    @Override
    public void setToolBar() {

    }

    @Override
    public void initView() {

        getSwipeBackLayout().setEnableGesture(false);
        if (Build.VERSION.SDK_INT >= 19) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerLaunchComponent.builder().launchHttpModule(new LaunchHttpModule()).build().injectWeChat(this);
    }

    @OnClick({R.id.layout_phone_login, R.id.layout_wchat_login, R.id.registered_shop_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_phone_login:
                ViewUtils.startActivity(new Intent(AliteLaunchActivity.this, AliteLoginActivity.class), this);
                break;
            case R.id.layout_wchat_login:

                if (!NetworkUtils.isConnected()) {
                    ToastUtils.showShortToast("网络连接已断开");
                    break;
                }

                if (StringUtil.isWeixinAvilible(this))
                    UMShareAPI.get(AliteLaunchActivity.this).getPlatformInfo(AliteLaunchActivity.this, WEIXIN, authListener);
                else
                    ToastUtils.showShortToast("请先安装微信应用");

                break;
            case R.id.registered_shop_account:
                ViewUtils.startActivity(new Intent(AliteLaunchActivity.this, AlitePhoneRegisterActivity.class), this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
          ShowLoadingDialog();
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data != null) {
                PreferUtil.getInstance().setWeixinUserInfo(data);
                Login login = new Login();
                login.setType(2);
                login.setWxUnionId(PreferUtil.getInstance().getWeixinUserInfo().getUnionid());
                login.setWxOpenId(PreferUtil.getInstance().getWeixinUserInfo().getOpenid());
                mPresenter.AuthShopLogin2(login);
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
           DismissLoadingDialog();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
           DismissLoadingDialog();
        }
    };

    @Override
    public void onAuthShopLogin2SuccessView(IMUserInfoVO usserInfo) {
        // 登录返回
       if(!usserInfo.isNeedBind()){
           //  之前绑定过 直接到首页
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
          DismissLoadingDialog();
           ViewUtils.startActivity(new Intent(AliteLaunchActivity.this, AliterHomeActivity.class), this);
       }else {
          DismissLoadingDialog();
//            UMShareAPI.get(AliteLaunchActivity.this).deleteOauth(AliteLaunchActivity.this, WEIXIN, null);
           ViewUtils.startActivity(new Intent(AliteLaunchActivity.this, AliteWeixinUserPhoneActivity.class), AliteLaunchActivity.this);
       }
    }

    @Override
    public void onFailView(String errorMsg) {

    }
}
