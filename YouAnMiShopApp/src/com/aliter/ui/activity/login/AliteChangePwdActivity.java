package com.aliter.ui.activity.login;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.ShopSetPassword2;
import com.aliter.injector.component.AliteChangePwdModule;
import com.aliter.injector.component.activity.DaggerAliteChangePwdComponent;
import com.aliter.presenter.AliteChangePwdPresenter;
import com.aliter.presenter.impl.AliteChangePwdPresenterImpl;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.EncryptionUtils;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class AliteChangePwdActivity extends BaseActivity<AliteChangePwdPresenterImpl> implements AliteChangePwdPresenter.View {


    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_back_pwd)
    Button btnBackPwd;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_clean_password)
    ImageView btnCleanPassword;
    private  boolean eyeOpen=false;

    @Override
    protected void onResume() {
        eyeOpen=false;
        super.onResume();
    }



    @Override
    public int getLayoutId() {
        return R.layout.alite_activity_change_pwd;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar, "");
        tvToolbar.setTextColor(this.getResources().getColor(R.color.black));
        tvToolbar.setText("设置新密码");
    }

    @Override
    public void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerAliteChangePwdComponent.builder().aliteChangePwdModule(new AliteChangePwdModule()).build().injectData(this);
    }

    @Override
    public void onShopSetPassword2SuccessView() {
        //设置密码成功返回
        ViewUtils.showToast(this.getResources().getString(R.string.set_new_pwd));
        Intent intent = new Intent();
        intent.putExtra("phoneNum",PreferUtil.getInstance().getShopAppSetPasswordPhoneNum());
        setResult(0, intent);
        finishActivity();
        finish();

    }

    @Override
    public void onFailView(String errorMsg) {
        //  设置密码失败返回
//        ViewUtils.showToast("设置密码失败");
    }

    @OnClick({R.id.btn_clean_password, R.id.btn_back_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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

            case R.id.btn_back_pwd:

                ShopSetPassword2 shopSetPassword2 = new ShopSetPassword2();
                shopSetPassword2.setPaw(EncryptionUtils.md5TransferPwd(editPassword.getText().toString()));
                shopSetPassword2.setUserName(PreferUtil.getInstance().getShopAppSetPasswordPhoneNum());
                shopSetPassword2.setCode(PreferUtil.getInstance().getShopAppSetPasswordCode());
                mPresenter.ShopSetPassword2(shopSetPassword2);

                break;
        }
    }
}
