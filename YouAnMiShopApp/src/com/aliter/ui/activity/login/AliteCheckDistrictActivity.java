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
import com.zxly.o2o.adapter.AddressAdapter;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.dialog.LoadingDialog;
import com.zxly.o2o.model.AddressCountry;
import com.zxly.o2o.model.AddressDistrict;
import com.zxly.o2o.shop.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by sayid on 2017/6/14.
 */

public class AliteCheckDistrictActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_view)
    ListView listView;

    private List<AddressCountry> areaList = null;
    private AddressAdapter adapter = null;
    private static ArrayList<AddressDistrict> districtList = new ArrayList<AddressDistrict>();
    private ArrayList<String> dataList = new ArrayList<String>();
    private LoadingDialog loadingDialog;
    private String districtName, districtId;
    private static int type;
    private boolean isCheck = false;


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
        adapter = new AddressAdapter(AliteCheckDistrictActivity.this);
        adapter.clear();
        adapter.addItem(getDistrictData());
        adapter.setCurrentState(2);
        ViewGroup headView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.item_custom_article_list_header, null);
        TextView txCtys = (TextView) headView.findViewById(R.id.tx_ctiy);
        txCtys.setText("请选择区/县");
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


    private ArrayList<String> getDistrictData() {
        if (districtList != null) {
            dataList.clear();
            for (AddressDistrict ac : districtList) {
                dataList.add(ac.getDistrictName());
            }
        }
        return dataList;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        isCheck = true;
        districtName = districtList.get(position - 1).getDistrictName();
        districtId = districtList.get(position - 1).getDistrictId();
        finish();
        finishActivity();
    }

    @Override
    public void onBackPressed() {
        type = 99;
        super.onBackPressed();
    }


    @Override
    public void finish() {
        Bundle mBundle = new Bundle();
        mBundle.putString("districtName", districtName);
        mBundle.putString("districtId", districtId);
        Intent intent = new Intent();
        intent.putExtras(mBundle);
        if (isCheck) {
            switch (type) {
                case 0:
                    setResult(0, intent);
                    break;
                case 1:
                    setResult(1000, intent);
                    break;
            }
        }
        super.finish();
    }

    @Override
    protected void onResume() {
        isCheck = false;
        super.onResume();
    }

    public static void start(Activity curAct, ArrayList<AddressDistrict> districtLists, int Checktype) {
        // Checktype ==0 没有城市  类似上海没有城市有区县
        type = Checktype;
        districtList = districtLists;
        Intent intent = new Intent(curAct, AliteCheckDistrictActivity.class);
        curAct.startActivityForResult(intent, 1);

    }
}
