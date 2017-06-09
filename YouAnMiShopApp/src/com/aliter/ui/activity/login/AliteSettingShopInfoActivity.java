package com.aliter.ui.activity.login;

import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.WeixinUserInfoBean;
import com.aliter.utils.GlideUtils;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.view.CircleImageView;

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
    @BindView(R.id.img_user_head)
    CircleImageView imgUserHead;
    @BindView(R.id.edit_shop_introduce)
    EditText editShopIntroduce;
    @BindView(R.id.layout_shop_introduce)
    RelativeLayout layoutShopIntroduce;
    @BindView(R.id.ai_icon_telephone)
    ImageView aiIconTelephone;
    @BindView(R.id.edit_shop_telephone)
    EditText editShopTelephone;
    @BindView(R.id.layout_shop_telephone)
    RelativeLayout layoutShopTelephone;
    @BindView(R.id.password_icon)
    ImageView passwordIcon;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.layout_shop_extension)
    RelativeLayout layoutShopExtension;
    @BindView(R.id.btn_back_pwd)
    Button btnBackPwd;

    private String iconurl;

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
        WeixinUserInfoBean weixinUserInfo = PreferUtil.getInstance().getWeixinUserInfo();
        if (weixinUserInfo != null) {
            iconurl = weixinUserInfo.getIconurl();
            GlideUtils.loadMovieTopImg(imgUserHead, iconurl);
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

    }


    @OnClick(R.id.img_user_head)
    public void onViewClicked() {
//        PhotoPicker.builder()
//                .setShowCamera(true)
//                .setPhotoCount(1)
//                .start(this);

    }
}
