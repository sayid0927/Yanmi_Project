package com.aliter.ui.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import com.zxly.o2o.dialog.LoadingDialog;
import com.zxly.o2o.model.AddressCity;
import com.zxly.o2o.model.AddressCountry;
import com.zxly.o2o.model.AddressDistrict;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by sayid on 2017/6/14.
 */

public class AliteCheckCityActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_view)
    ListView listView;

    private List<AddressCountry> areaList = null;
    private AddressAdapter adapter = null;
    private static ArrayList<AddressCity> cityList = new ArrayList<AddressCity>();
    private ArrayList<AddressDistrict> districtList = new ArrayList<AddressDistrict>();

    private ArrayList<String> dataList = new ArrayList<String>();
    private LoadingDialog loadingDialog;
    private String cityName, cityId, districtName, districtId;
    private int type;


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
        adapter = new AddressAdapter(AliteCheckCityActivity.this);
        adapter.clear();
        adapter.addItem(getCityData());
        adapter.setCurrentState(2);
        ViewGroup headView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.item_custom_article_list_header, null);
        TextView txCtys = (TextView) headView.findViewById(R.id.tx_ctiy);
        txCtys.setText("请选择省/直辖市");
        listView.addHeaderView(headView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void loadData() {


    }

    @Override
    protected void initInject() {
    }

    private ArrayList<String> getCityData() {
        if (cityList != null) {
            dataList.clear();
            for (AddressCity ac : cityList) {
                dataList.add(ac.getCityName());
            }
        }
        return dataList;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        cityName = cityList.get(position - 1).getCityName();
        cityId = cityList.get(position - 1).getCityId();
        districtList = (ArrayList<AddressDistrict>) cityList.get(position - 1).getDistricts();
        if (districtList.size() != 0) {
            districtList = (ArrayList<AddressDistrict>) cityList.get(0).getDistricts();
            if (districtList.get(0).getDistrictId() != null)
                AliteCheckDistrictActivity.start(AliteCheckCityActivity.this, districtList, 1);
        } else {
            Intent data = new Intent();
            data.putExtra("receiptList", 1000);
            setResult(Activity.RESULT_OK, data);
            finish();
        }
    }

    @Override
    public void finish() {

        Bundle mBundle = new Bundle();
        mBundle.putString("districtName", districtName);
        mBundle.putString("districtId", districtId);
        Intent intent = new Intent();
        intent.putExtras(mBundle);
        if (type == 0)
            setResult(RESULT_OK, intent);
        else
            setResult(1000, intent);
        finishActivity();
        super.finish();
    }

    public static void start(Activity curAct, ArrayList<AddressCity> cityArrayList) {
        cityList = cityArrayList;
        Intent intent = new Intent(curAct, AliteCheckCityActivity.class);
        curAct.startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.t("TAG").e("requestCode  ==  " + String.valueOf(requestCode));
        Logger.t("TAG").e("data  ==  " + String.valueOf(data));
        Logger.t("TAG").e("resultCode  ==  " + String.valueOf(resultCode));
        if (requestCode == 1) {
            if (data != null) {
                Bundle mBundle = data.getExtras();
                districtName = mBundle.getString("districtName");
                districtId = mBundle.getString("districtId");
                if (resultCode == 0) {
                    type = 0;
                    finish();
                    finishActivity();
                } else {
                    type = 1000;
                    finish();
                    finishActivity();
                }
            }
        }
    }
}
