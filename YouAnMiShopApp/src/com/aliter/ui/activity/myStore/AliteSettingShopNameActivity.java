package com.aliter.ui.activity.myStore;

import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.aliter.entity.ShopUpdate;
import com.aliter.injector.component.SettingMyShopInfoModule;
import com.aliter.injector.component.activity.DaggerSettingMyShopInfoComponent;
import com.aliter.presenter.SettingMyShopInfoActivityPresenter;
import com.aliter.presenter.impl.SettingMyShopInfoActivityPresenterImpl;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/23.
 */

public class AliteSettingShopNameActivity extends BaseActivity<SettingMyShopInfoActivityPresenterImpl> implements SettingMyShopInfoActivityPresenter.View {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_clean_shopname)
    ImageView btnCleanShopname;
    @BindView(R.id.edit_shop_name)
    EditText editShopName;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_right_top)
    TextView tvRightTop;

    private int type;
    private String name;

    @Override
    public int getLayoutId() {
        return R.layout.alite_aitivity_setting_shopname;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar, "");
        tvRightTop.setText("保存");
        tvRightTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
        switch (type) {
            case 1:
                tvToolbar.setText("门店名称");
                break;
            case 2:
                tvToolbar.setText("门店标语");
                break;

            case 3:
                tvToolbar.setText("客服电话");
                break;
            case 4:
                tvToolbar.setText("详情地址");
                break;

        }

    }

    @Override
    public void initView() {


        type = getIntent().getIntExtra("TYPE", 0);
        name = getIntent().getStringExtra("Name");
        if (!StringUtil.isNull(name)) {
            editShopName.setText(name);
            tvNum.setText(String.valueOf(editShopName.getText().length())+ "/30");
            btnCleanShopname.setVisibility(View.VISIBLE);
        }
        switch (type) {
            case 1:
                editShopName.setHint("门店名称");
                break;
            case 2:
                editShopName.setHint("门店标语");
                break;

            case 3:
                editShopName.setHint("客服电话");
                editShopName.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case 4:
                editShopName.setHint("详情地址");
                break;
        }


        editShopName.addTextChangedListener(new TextWatcher() {
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
                    btnCleanShopname.setVisibility(View.GONE);

                } else {
                    btnCleanShopname.setVisibility(View.VISIBLE);
                    tvNum.setText(String.valueOf(s.length()) + "/30");
                }
                if (temp.length() > 30) {
                    s.delete(30, s.length());
                    editShopName.setText(s);
                    editShopName.setSelection(s.length());
                    ViewUtils.showToast("门店名称只能为30位的数字或字母组成");
                }
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
        DaggerSettingMyShopInfoComponent.builder().settingMyShopInfoModule(new SettingMyShopInfoModule()).build().injectWeChat(this);
    }


    @OnClick(R.id.btn_clean_shopname)
    public void onViewClicked() {
        editShopName.setText("");
        tvNum.setText("0/30");
    }


    private void Save() {

        ShopUpdate shopUpdate = new ShopUpdate();

        switch (type) {

            case 1:

                break;
            case 2:
                shopUpdate.setType(2);
                shopUpdate.setShopId(Account.user.getShopId());
                shopUpdate.setSlogan(editShopName.getText().toString());
                mPresenter.ShopUpdate(shopUpdate);
                ShowLoadingDialog();

                break;
            case 3:

                shopUpdate.setType(3);
                shopUpdate.setShopId(Account.user.getShopId());
                shopUpdate.setServerPhone(editShopName.getText().toString());
                mPresenter.ShopUpdate(shopUpdate);
                ShowLoadingDialog();

                break;
            case 4:
                shopUpdate.setType(5);
                shopUpdate.setShopId(Account.user.getShopId());
                shopUpdate.setDetailedAddress(editShopName.getText().toString());
                mPresenter.ShopUpdate(shopUpdate);
                ShowLoadingDialog();
                break;

        }
    }


    @Override
    public void onShopUpdateSuccessView() {
        DismissLoadingDialog();
        ViewUtils.showToast("设置成功");
        switch (type){
            case  1:
                break;
            case  2:
                PreferUtil.getInstance().putString(PreferUtil.SHOP_INFO_SLOGAN,editShopName.getText().toString());
                break;
            case  3:
                PreferUtil.getInstance().putString(PreferUtil.SHOP_INFO_SERVERPHONE,editShopName.getText().toString());
                break;
            case  4:
                PreferUtil.getInstance().putString(PreferUtil.SHOP_INFO_DETAILEDADDRESS,editShopName.getText().toString());
                break;
        }
        finish();
        finishActivity();
    }

    @Override
    public void onFailView(String errorMsg) {
        DismissLoadingDialog();
    }
}
