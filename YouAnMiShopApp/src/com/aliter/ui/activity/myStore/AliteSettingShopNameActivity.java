package com.aliter.ui.activity.myStore;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sayid on 2017/6/23.
 */

public class AliteSettingShopNameActivity extends BaseActivity {
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
                finish();
                finishActivity();
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

        switch (type) {
            case 1:
                editShopName.setHint("门店名称");
                break;
            case 2:
                editShopName.setHint("门店标语");
                break;

            case 3:
                editShopName.setHint("客服电话");
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

    }


    @OnClick(R.id.btn_clean_shopname)
    public void onViewClicked() {
        editShopName.setText("");
        tvNum.setText("0/30");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
