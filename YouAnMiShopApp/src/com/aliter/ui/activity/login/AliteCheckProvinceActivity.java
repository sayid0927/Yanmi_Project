package com.aliter.ui.activity.login;

import android.content.Intent;
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
import com.orhanobut.logger.Logger;
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
    private String provinceName,provinceId;

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
        provinceName = provinceList.get(position-1).getProvinceName();
        provinceId = provinceList.get(position-1).getProvinceId();
        cityList = (ArrayList<AddressCity>) provinceList.get(position-1).getCitys();
        if(cityList.get(0).getCityId() != null){

            AliteCheckCityActivity.start(AliteCheckProvinceActivity.this,cityList);

        } else {
            districtList = (ArrayList<AddressDistrict>) cityList.get(0).getDistricts();
            if (districtList.size() != 0) {

                AliteCheckDistrictActivity.start(AliteCheckProvinceActivity.this,districtList,0);

            }
        }
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

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
