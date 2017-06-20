package com.aliter.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.ShopRegister;
import com.aliter.entity.WeixinUserInfoBean;
import com.aliter.injector.component.AliteSettingShopInfoHttpModule;
import com.aliter.injector.component.activity.DaggerAliteSettingShopInfoComponent;
import com.aliter.presenter.AliteSettingShopInfoPresenter;
import com.aliter.presenter.impl.AliteSettingShopInfoPresenterImpl;
import com.aliter.ui.activity.AliterHomeActivity;
import com.blankj.utilcode.utils.StringUtils;
import com.easemob.chatuidemo.HXConstant;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.application.Config;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.DESUtils;
import com.zxly.o2o.util.EncryptionUtils;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by sayid on 2017/6/6.
 */

public class AliteSettingShopInfoActivity extends BaseActivity<AliteSettingShopInfoPresenterImpl> implements AliteSettingShopInfoPresenter.View {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ai_icon_telephone)
    ImageView aiIconTelephone;
    @BindView(R.id.layout_shop_telephone)
    RelativeLayout layoutShopTelephone;
    @BindView(R.id.password_icon)
    ImageView passwordIcon;
    @BindView(R.id.layout_shop_extension)
    RelativeLayout layoutShopExtension;
    @BindView(R.id.layout_shop_introduce)
    RelativeLayout layoutShopIntroduce;
    @BindView(R.id.btn_back_pwd)
    Button btnBackPwd;
    @BindView(R.id.tv_shop_introduce)
    TextView tvShopIntroduce;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.edit_shop_name)
    EditText editShopName;
    @BindView(R.id.edit_shop_telephone)
    EditText editShopTelephone;
    @BindView(R.id.edit_generalizeCode)
    EditText editGeneralizeCode;

    private String iconurl;
    private String provinceId, cityName, districtId, districtName, cityId, provinceName, GeneralizeCode;
    private WeixinUserInfoBean weixinUserInfo;


    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_setting_shop_info;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar, "");
    }

    @Override
    public void initView() {

        initListener();
        btnBackPwd.setEnabled(false);
        btnBackPwd.setTextColor(getResources().getColor(R.color.white));

        weixinUserInfo = PreferUtil.getInstance().getWeixinUserInfo();
        if (weixinUserInfo != null)
            editShopTelephone.setText(weixinUserInfo.getName()); //如果微信登录的话设置微信昵称

        StringUtil.changeScrollView(editShopName, scrollView);
        StringUtil.changeScrollView(editGeneralizeCode, scrollView);
        StringUtil.changeScrollView(editShopTelephone, scrollView);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerAliteSettingShopInfoComponent.builder().aliteSettingShopInfoHttpModule(new AliteSettingShopInfoHttpModule()).build().injectData(this);
    }


    @OnClick({R.id.layout_shop_introduce, R.id.btn_back_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_shop_introduce:
                Intent intent = new Intent(AliteSettingShopInfoActivity.this, AliteCheckProvinceActivity.class);

                AliteSettingShopInfoActivity.this.startActivityForResult(intent, 1);
                startActivityIn();
                break;
            case R.id.btn_back_pwd:
                if (editShopName.getText().length() == 0) {
                    ViewUtils.showToast("请填写门店名称");
                    break;
                }
                if (tvShopIntroduce.getText().length() == 0) {
                    ViewUtils.showToast("请选择门店所在地区");
                    break;
                }
                if (editShopTelephone.getText().length() == 0) {
                    ViewUtils.showToast("请填写门店联系人");
                    break;
                }
                if (editGeneralizeCode.getText().length() != 0) {
                    GeneralizeCode = editGeneralizeCode.getText().toString();
                } else {
                    GeneralizeCode = "";
                }

                ShopRegister shopRegister = new ShopRegister();
                shopRegister.setCode(PreferUtil.getInstance().getRegisterCode());  //验证码
                shopRegister.setGeneralizeCode(GeneralizeCode);                      // 推广码
                shopRegister.setShopName(editShopName.getText().toString());         // 门店名称
                shopRegister.setUserName(PreferUtil.getInstance().getRegisterPhonenum()); //  用户帐号 注册的手机号
                shopRegister.setPassword(PreferUtil.getInstance().getRegisterPwd());       //  密码
                shopRegister.setNickName(editShopTelephone.getText().toString());           // 昵称
                if (provinceId != null)
                    shopRegister.setProvinceId(Integer.valueOf(provinceId));              //省份id
                if (cityId != null)
                    shopRegister.setCityId(Integer.valueOf(cityId));                     //城市id
                if (districtId != null)
                    shopRegister.setAreaId(Integer.valueOf(districtId));                 //地区id
                if (weixinUserInfo != null) {
                    shopRegister.setWxOpenId(weixinUserInfo.getOpenid());               //微信用户openId
                    shopRegister.setWxUnionId(weixinUserInfo.getUid());                 //微信用户统一id
                    shopRegister.setWxHeadUrl(weixinUserInfo.getIconurl());             // 微信头像地址
                }
                mPresenter.fetchShopRegister(shopRegister);
                ShowLoadingDialog();
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (data != null) {
                Bundle mBundle = data.getExtras();
                switch (resultCode) {
                    case 0:
                        districtName = mBundle.getString("districtName");
                        districtId = mBundle.getString("districtId");
                        provinceName = mBundle.getString("provinceName");
                        provinceId = mBundle.getString("provinceId");
                        cityName = mBundle.getString("cityName");
                        cityId = mBundle.getString("cityId");
                        tvShopIntroduce.setText(provinceName + " " + districtName);
                        break;
                    case 1000:
                        districtName = mBundle.getString("districtName");
                        districtId = mBundle.getString("districtId");
                        provinceName = mBundle.getString("provinceName");
                        provinceId = mBundle.getString("provinceId");
                        cityName = mBundle.getString("cityName");
                        cityId = mBundle.getString("cityId");
                        tvShopIntroduce.setText(provinceName + " " + cityName + " " + districtName);
                        break;
                    case 1001:
                        provinceName = mBundle.getString("provinceName");
                        provinceId = mBundle.getString("provinceId");
                        cityName = mBundle.getString("cityName");
                        cityId = mBundle.getString("cityId");
                        tvShopIntroduce.setText(provinceName + " " + cityName);
                        break;
                }
            }
        }
    }

    @Override
    public void onShopRegisterSuccessView(IMUserInfoVO usserInfo) {
          //  注册成功直接跳转到首页
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
        PreferUtil.getInstance().CleanWeixinUserInfo(weixinUserInfo);
        DismissLoadingDialog();
        ViewUtils.startActivity(new Intent(AliteSettingShopInfoActivity.this, AliterHomeActivity.class), this);

    }

    @Override
    public void onFailView(String errorMsg) {
            DismissLoadingDialog();
    }




    private void initListener() {

        editShopName.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnBackPwd.setEnabled(false);
                } else {
                        if (!StringUtil.isNull(tvShopIntroduce.getText().toString())&& !StringUtil.isNull(editShopTelephone.getText().toString())) {
                            btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_phone);
                            btnBackPwd.setEnabled(true);
                        } else {
                            btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                            btnBackPwd.setEnabled(false);
                            btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                        }
                    }
            }
        });
        editShopTelephone.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnBackPwd.setEnabled(false);
                } else {
                    if (!StringUtil.isNull(tvShopIntroduce.getText().toString())&& !StringUtil.isNull(editShopName.getText().toString())) {
                        btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_phone);
                        btnBackPwd.setEnabled(true);
                    } else {
                        btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnBackPwd.setEnabled(false);
                        btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                    }
                }
            }
        });
        tvShopIntroduce.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                    btnBackPwd.setEnabled(false);
                } else {
                    if (!StringUtil.isNull(editShopTelephone.getText().toString())&& !StringUtil.isNull(editShopName.getText().toString())) {
                        btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_phone);
                        btnBackPwd.setEnabled(true);
                    } else {
                        btnBackPwd.setBackgroundResource(R.drawable.alite_btn_login_default);
                        btnBackPwd.setEnabled(false);
                        btnBackPwd.setTextColor(getResources().getColor(R.color.white));
                    }
                }
            }
        });
    }
}
