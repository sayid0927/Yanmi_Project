package com.aliter.ui.activity.login;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.ui.activity.AliterHomeActivity;
import com.orhanobut.logger.Logger;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by sayid on 2017/6/6.
 */

public class AliteSettingShopInfoActivity extends BaseActivity {
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
    @BindView(R.id.edit_password)
    EditText editPassword;
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

    private String iconurl;

    public  static AliteSettingShopInfoActivity instance=null;

    private String provinceId, cityName, districtId, districtName, cityId, provinceName;

    @Override
    public void setState(int state) {

    }

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
        instance=this;
        StringUtil.changeScrollView(editShopName, scrollView);
        StringUtil.changeScrollView(editPassword, scrollView);
        StringUtil.changeScrollView(editShopTelephone, scrollView);
//        WeixinUserInfoBean weixinUserInfo = PreferUtil.getInstance().getWeixinUserInfo();
//        if (weixinUserInfo != null) {
//            iconurl = weixinUserInfo.getIconurl();
//            GlideUtils.loadMovieTopImg(imgUserHead, iconurl);
//        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }


    @OnClick({R.id.layout_shop_introduce, R.id.btn_back_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_shop_introduce:


                Intent intent = new Intent(AliteSettingShopInfoActivity.this, AliteCheckProvinceActivity.class);
                AliteSettingShopInfoActivity.this.startActivityForResult(intent, 1);

//                Intent i = new Intent(AliteSettingShopInfoActivity.this, AliteCheckProvinceActivity.class);
//                AliteSettingShopInfoActivity.this.startActivityForResult(i,100);
             //   ViewUtils.startActivity(i, this);


//                AreaAct.start(AliteSettingShopInfoActivity.this, new ParameCallBack() {
//                    @Override
//                    public void onCall(Object object) {
//                        Map<String, String> result = (Map<String, String>) object;
//                        provinceId = result.get("provinceId");
//                        cityId = result.get("cityId");
//                        provinceName = result.get("provinceName");
//                        cityName = result.get("cityName");
//                        districtId = result.get("districtId");
//                        districtName = result.get("districtName");
//                        if (cityName == null)
//                            cityName = "";
//                        if (districtName == null)
//                            districtName = "";
//                        tvShopIntroduce.setText(provinceName + " " + cityName + " " + districtName);
//                    }
//                });
                break;
            case R.id.btn_back_pwd:
                ViewUtils.startActivity(new Intent(AliteSettingShopInfoActivity.this, AliterHomeActivity.class), this);
                break;
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.t("TAG").e("requestCode  ==  "+String.valueOf(requestCode));
        Logger.t("TAG").e("data  ==  "+String.valueOf(data));
        Logger.t("TAG").e("resultCode  ==  "+String.valueOf(resultCode));
        if(requestCode==1){
            if(resultCode==0){


            }else {


            }
        }
    }
}
