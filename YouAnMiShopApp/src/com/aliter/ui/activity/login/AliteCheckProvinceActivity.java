package com.aliter.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.aliter.base.BaseActivity;
import com.zxly.o2o.adapter.AddressAdapter;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.application.Config;
import com.zxly.o2o.dialog.LoadingDialog;
import com.zxly.o2o.model.AddressCity;
import com.zxly.o2o.model.AddressCountry;
import com.zxly.o2o.model.AddressDistrict;
import com.zxly.o2o.model.AddressProvince;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.AreaUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by sayid on 2017/6/14.
 */

public class AliteCheckProvinceActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_view)
    ListView listView;

    private List<AddressCountry> areaList = null;
    private AddressAdapter adapter = null;
    private ArrayList<AddressProvince> provinceList = new ArrayList<AddressProvince>();
    private ArrayList<String> dataList = new ArrayList<String>();
    private ArrayList<AddressCity> cityList = new ArrayList<AddressCity>();
    private ArrayList<AddressDistrict> districtList = new ArrayList<AddressDistrict>();
    private LoadingDialog loadingDialog;

    private String cityName, cityId, districtName, districtId;
    private int type;
    private boolean isCheck = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1000) {
                if (loadingDialog.isShow())
                    loadingDialog.dismiss();
                initViews();
            }
        }
    };
    private String provinceName, provinceId;

    @Override
    public void setState(int state) {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    public int getLayoutId() {
        return R.layout.alite_activity_check_province;
    }

    @Override
    public void setToolBar() {
        setToolBar(toolbar, "");
        tvToolbar.setText("地区");
    }

    @Override
    public void initView() {
        areaList = Config.areaList;
        if (areaList != null && !areaList.isEmpty()) {
            initViews();
        } else {
            loadingDialog = new LoadingDialog(AliteCheckProvinceActivity.this);
            loadingDialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Config.areaList = AreaUtil.getAreaFromFile();
                    areaList = Config.areaList;
                    if (areaList != null && !areaList.isEmpty()) {
                        handler.sendEmptyMessage(1000);
                    }
                }
            }).start();
        }
    }

    @Override
    protected void loadData() {
    }

    @Override
    protected void initInject() {
    }

    @Override
    protected void onResume() {
        isCheck = false;
        super.onResume();
    }

    private void initViews() {
        adapter = new AddressAdapter(AliteCheckProvinceActivity.this);
        adapter.clear();
        adapter.addItem(getProvinceData());
        adapter.setCurrentState(1);
        ViewGroup headView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.item_custom_article_list_header, null);
        TextView txCtys = (TextView) headView.findViewById(R.id.tx_ctiy);
        txCtys.setText("请选择省/直辖市");
        listView.addHeaderView(headView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private ArrayList<String> getProvinceData() {
        if (areaList != null) {
            provinceList = (ArrayList<AddressProvince>) areaList.get(0).getPrvs();
            dataList.clear();
            for (AddressProvince ap : provinceList) {
                dataList.add(ap.getProvinceName());
            }
        }
        return dataList;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        isCheck = true;
        provinceName = provinceList.get(position - 1).getProvinceName();
        provinceId = provinceList.get(position - 1).getProvinceId();
        cityList = (ArrayList<AddressCity>) provinceList.get(position - 1).getCitys();
        if (cityList.get(0).getCityId() != null) {
            AliteCheckCityActivity.start(AliteCheckProvinceActivity.this, cityList);
            startActivityIn();
        } else {
            districtList = (ArrayList<AddressDistrict>) cityList.get(0).getDistricts();
            if (districtList.size() != 0) {
                AliteCheckDistrictActivity.start(AliteCheckProvinceActivity.this, districtList, 0);
                startActivityIn();
            }
        }
    }

    @Override
    public void onBackPressed() {
        type = 99;
        super.onBackPressed();
    }

    @Override
    public void finish() {
        Bundle mBundle = new Bundle();
        Intent intent = new Intent();
        if (isCheck) {
            switch (type) {
                case 0:
                    mBundle.putString("districtName", districtName);
                    mBundle.putString("districtId", districtId);
                    mBundle.putString("provinceName", provinceName);
                    mBundle.putString("provinceId", provinceId);
                    intent.putExtras(mBundle);
                    setResult(0, intent);
                    break;
                case 1000:
                    mBundle.putString("districtName", districtName);
                    mBundle.putString("districtId", districtId);
                    mBundle.putString("cityName", cityName);
                    mBundle.putString("cityId", cityId);
                    mBundle.putString("provinceName", provinceName);
                    mBundle.putString("provinceId", provinceId);
                    intent.putExtras(mBundle);
                    setResult(1000, intent);
                    break;
                case 1001:
                    mBundle.putString("cityName", cityName);
                    mBundle.putString("cityId", cityId);
                    mBundle.putString("provinceName", provinceName);
                    mBundle.putString("provinceId", provinceId);
                    intent.putExtras(mBundle);
                    setResult(1001, intent);
                    break;
            }
        }
        super.finish();
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
                        type = 0;
                        break;
                    case 1000:
                        type = 1000;
                        districtName = mBundle.getString("districtName");
                        districtId = mBundle.getString("districtId");
                        cityName = mBundle.getString("cityName");
                        cityId = mBundle.getString("cityId");

                        break;
                    case 1001:
                        type = 1001;
                        cityName = mBundle.getString("cityName");
                        cityId = mBundle.getString("cityId");
                        break;
                }
                finish();
                finishActivity();
            }
        }
    }
}
