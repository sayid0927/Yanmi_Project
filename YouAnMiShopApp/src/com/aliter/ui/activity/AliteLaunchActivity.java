package com.aliter.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/5.
 */

public class AliteLaunchActivity extends BaseActivity {


    @BindView(R.id.layout_phone_login)
    RelativeLayout layoutPhoneLogin;
    @BindView(R.id.layout_wchat_login)
    RelativeLayout layoutWchatLogin;
    @BindView(R.id.registered_shop_account)
    TextView registeredShopAccount;

    @Override
    public void setState(int state) {

    }

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

    }

    @OnClick({R.id.layout_phone_login, R.id.layout_wchat_login,R.id.registered_shop_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_phone_login:
                ViewUtils.startActivity(new Intent(AliteLaunchActivity.this,AliteLoginActivity.class), this);
                break;
            case R.id.layout_wchat_login:
                break;
            case R.id.registered_shop_account:
                break;
        }
    }


}
