package com.aliter.ui.fragment;


import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.base.BaseFragment;
import com.zxly.o2o.activity.MobileDataAct;
import com.zxly.o2o.activity.MyOrderAct;
import com.zxly.o2o.activity.SalesmanRankingAct;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MyStoreFragmentAlite extends BaseFragment {


    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.tv_youbao)
    TextView tvYoubao;
    @BindView(R.id.layout_my_order)
    RelativeLayout layoutMyOrder;
    @BindView(R.id.tv_employee_list)
    TextView tvEmployeeList;
    @BindView(R.id.btn_user_collect)
    TextView btnUserCollect;


    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_my_store;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {

    }


    @OnClick({R.id.tv_recharge, R.id.tv_youbao, R.id.layout_my_order, R.id.tv_employee_list, R.id.btn_user_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_recharge:  //  流量冲值
                MobileDataAct.start(getActivity());

                break;
            case R.id.tv_youbao:    //  碎柚宝
                break;
            case R.id.layout_my_order:     //  我的订单
                MyOrderAct.startMyorderAct(getActivity(), MyOrderAct.ORDER_REQUEST_ALL);
                break;
            case R.id.tv_employee_list:   // 店员榜单
                SalesmanRankingAct.start(getActivity());

                break;
            case R.id.btn_user_collect:
                break;
        }
    }
}
