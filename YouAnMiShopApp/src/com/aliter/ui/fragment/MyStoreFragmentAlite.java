package com.aliter.ui.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.base.BaseFragment;
import com.aliter.ui.activity.myStore.AliteSettingMyShopInfoActivity;
import com.aliter.ui.activity.myStore.AllCustomerActivity;
import com.zxly.o2o.activity.FragmentListAct;
import com.zxly.o2o.activity.GetFavorableStatisticsAct;
import com.zxly.o2o.activity.MobileDataAct;
import com.zxly.o2o.activity.MyOrderAct;
import com.zxly.o2o.activity.SalesmanRankingAct;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.UmengUtil;
import com.zxly.o2o.util.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

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
    @BindView(R.id.btn_ddyh)
    TextView btnDdyh;
    Unbinder unbinder;
    @BindView(R.id.btn_user_topic)
    TextView btnUserTopic;
    Unbinder unbinder1;
    @BindView(R.id.ll_setting_user_name)
    LinearLayout llSettingUserName;
    Unbinder unbinder2;


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


    @OnClick({R.id.tv_recharge, R.id.tv_youbao, R.id.layout_my_order, R.id.tv_employee_list, R.id.btn_user_collect, R.id.btn_ddyh,
            R.id.btn_user_topic, R.id.ll_setting_user_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_recharge:  //  流量冲值
                MobileDataAct.start(getActivity());
                break;
            case R.id.tv_youbao:    //  碎柚宝
                FragmentListAct.start("延保管理", FragmentListAct.PAGE_GUARANTEE_MANAGE);
                UmengUtil.onEvent(getActivity(), new UmengUtil().MONEY_INSURANCE_CLICK, null);
                break;
            case R.id.layout_my_order:     //  我的订单
                MyOrderAct.startMyorderAct(getActivity(), MyOrderAct.ORDER_REQUEST_ALL);
                break;
            case R.id.tv_employee_list:   // 店员榜单
                SalesmanRankingAct.start(getActivity());
                break;
            case R.id.btn_user_collect:
                break;
            case R.id.btn_ddyh:  //     客多多
                Intent intent = new Intent(getActivity(), AllCustomerActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_user_topic://优惠领取清单

                GetFavorableStatisticsAct.start(getActivity());
                UmengUtil.onEvent(getActivity(), new UmengUtil().MANAGE_DISCOUNTRECEIVE_CLICK, null);

//                if (Account.user.getRoleType() == Constants.USER_TYPE_ADMIN) {
//                    GetFavorableStatisticsAct.start(getActivity());
//                } else {
//                    EaseConstant.startBenefitsActivity(getActivity());
//                }
//                EaseConstant.startBenefitsActivity(getActivity());


            case R.id.ll_setting_user_name:  //     设置门店名

                ViewUtils.startActivity(new Intent(getActivity(),AliteSettingMyShopInfoActivity.class),getActivity());

                break;
        }
    }
}
