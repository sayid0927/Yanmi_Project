package com.aliter.ui.fragment;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.base.BaseFragment;
import com.aliter.entity.MySroreAuthority;
import com.aliter.entity.ShopInfoBase;
import com.aliter.injector.component.MyStroreHttpModule;
import com.aliter.injector.component.fragment.DaggerMyStoreComponent;
import com.aliter.injector.component.module.fragment.MyStroreAdapterModule;
import com.aliter.presenter.MyStorePresenter;
import com.aliter.presenter.impl.ShopInfoPresenterImpl;
import com.aliter.ui.activity.myStore.AliteSettingMyShopInfoActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.easemob.easeui.EaseConstant;
import com.orhanobut.logger.Logger;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.activity.FragmentListAct;
import com.zxly.o2o.activity.GetFavorableStatisticsAct;
import com.zxly.o2o.activity.MobileDataAct;
import com.zxly.o2o.activity.MyOrderAct;
import com.zxly.o2o.activity.SalesmanRankingAct;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.Constants;
import com.zxly.o2o.util.PreferUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.UmengUtil;
import com.zxly.o2o.util.ViewUtils;
import com.zxly.o2o.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MyStoreFragmentAlite extends BaseFragment<ShopInfoPresenterImpl> implements MyStorePresenter.View {


    //    @BindView(R.id.tv_recharge)
//    TextView tvRecharge;
//    @BindView(R.id.tv_youbao)
//    TextView tvYoubao;
//    @BindView(R.id.layout_my_order)
//    RelativeLayout layoutMyOrder;
//    @BindView(R.id.tv_employee_list)
//    TextView tvEmployeeList;
//    @BindView(R.id.btn_user_collect)
//    TextView btnUserCollect;
//    @BindView(R.id.btn_ddyh)
//    TextView btnDdyh;
//    @BindView(R.id.btn_user_topic)
//    TextView btnUserTopic;
    @BindView(R.id.ll_setting_user_name)
    LinearLayout llSettingUserName;
    @BindView(R.id.layout_my_shop)
    RelativeLayout layoutMyShop;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.img_user_head)
    CircleImageView imgUserHead;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @Inject
    protected BaseQuickAdapter mAdapter;


    @Override
    protected void loadData() {

        mPresenter.ShopInfo();
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_my_store;
    }

    @Override
    protected void initView() {
        final List<MySroreAuthority> list = new ArrayList<>();
//     * {"id":10,"menuName":"碎柚保","parentId":2,"type":2,"orders":2,"code":"syb001"},
//     * {"id":11,"menuName":"流量充值","parentId":2,"type":2,"orders":3,"code":"llcz001"},
//     * {"id":12,"menuName":"赚佣金","parentId":2,"type":2,"orders":4,"code":"zyj001"},
//     * {"id":13,"menuName":"店员榜单","parentId":2,"type":2,"orders":5,"code":"dybd001"},
//     * {"id":14,"menuName":"送货清单","parentId":2,"type":2,"orders":6,"code":"shqd001"},
//     * {"id":15,"menuName":"优惠领取","parentId":2,"type":2,"orders":7,"code":"yhlq001"},
//     * {"id":16,"menuName":"优惠统计","parentId":2,"type":2,"orders":8,"code":"yhtj001"},
//     * {"id":17,"menuName":"订单管理","parentId":2,"type":2,"orders":9,"code":"ddgl001"},

        if (PreferUtil.getInstance().getSyb001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_screensaver));
            mySroreAuthority.setTitle("碎柚宝");
            mySroreAuthority.setType(1);
            list.add(mySroreAuthority);
        }
        if (PreferUtil.getInstance().getLlczb001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_recharge));
            mySroreAuthority.setTitle("流量充值");
            mySroreAuthority.setType(2);
            list.add(mySroreAuthority);
        }
        if (PreferUtil.getInstance().getZyj001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_recharge));
            mySroreAuthority.setTitle("赚佣金");
            mySroreAuthority.setType(3);
            list.add(mySroreAuthority);
        }
        if (PreferUtil.getInstance().getDybd001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_list));
            mySroreAuthority.setTitle("店员榜单");
            mySroreAuthority.setType(4);
            list.add(mySroreAuthority);
        }
        if (PreferUtil.getInstance().getShqd001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_order));
            mySroreAuthority.setTitle("送货清单");
            mySroreAuthority.setType(5);
            list.add(mySroreAuthority);
        }

        if (PreferUtil.getInstance().getYhlq001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_commission));
            mySroreAuthority.setTitle("优惠领取");
            mySroreAuthority.setType(6);
            list.add(mySroreAuthority);
        }
        if (PreferUtil.getInstance().getYhtj001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_commission));
            mySroreAuthority.setTitle("优惠统计");
            mySroreAuthority.setType(7);
            list.add(mySroreAuthority);
        }
        if (PreferUtil.getInstance().getDdgl001()) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_order));
            mySroreAuthority.setTitle("订单管理");
            mySroreAuthority.setType(8);
            list.add(mySroreAuthority);
        }

        if (list.size() == 0) {
            MySroreAuthority mySroreAuthority = new MySroreAuthority();
            mySroreAuthority.setBitmap(getActivity().getResources().getDrawable(R.drawable.al_icon_recharge));
            mySroreAuthority.setTitle("流量充值");
            mySroreAuthority.setType(2);
            list.add(mySroreAuthority);
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(list);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                switch (list.get(position).getType()) {
                    case 1:
                        FragmentListAct.start("延保管理", FragmentListAct.PAGE_GUARANTEE_MANAGE);
                        UmengUtil.onEvent(getActivity(), new UmengUtil().MONEY_INSURANCE_CLICK, null);
                        break;
                    case 2:
                        MobileDataAct.start(getActivity());
                        break;
                    case 3:
                        break;
                    case 4:
                        SalesmanRankingAct.start(getActivity());
                        break;
                    case 5:
                        MyOrderAct.startMyorderAct(getActivity(), MyOrderAct.ORDER_REQUEST_ALL);
                        break;
                    case 6:

                        if (Account.user.getRoleType() == Constants.USER_TYPE_ADMIN) {
                            GetFavorableStatisticsAct.start(getActivity());
                        } else {
                            EaseConstant.startBenefitsActivity(getActivity());
                        }
                        EaseConstant.startBenefitsActivity(getActivity());

                        break;
                    case 7:
                        GetFavorableStatisticsAct.start(getActivity());
                        UmengUtil.onEvent(getActivity(), new UmengUtil().MANAGE_DISCOUNTRECEIVE_CLICK, null);
                        break;
                    case 8:
                        MyOrderAct.startMyorderAct(getActivity(), MyOrderAct.ORDER_REQUEST_ALL);
                        break;

                }

            }
        });
    }

    @Override
    protected void initInject() {
        DaggerMyStoreComponent.builder().myStroreHttpModule(new MyStroreHttpModule()).myStroreAdapterModule(new MyStroreAdapterModule()).build().injectData(this);
    }


    @OnClick({R.id.ll_setting_user_name, R.id.layout_my_shop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.tv_recharge:  //  流量冲值
//                MobileDataAct.start(getActivity());
//                break;
//            case R.id.tv_youbao:    //  碎柚宝
//                FragmentListAct.start("延保管理", FragmentListAct.PAGE_GUARANTEE_MANAGE);
//                UmengUtil.onEvent(getActivity(), new UmengUtil().MONEY_INSURANCE_CLICK, null);
//                break;
//            case R.id.layout_my_order:     //  我的订单
//                MyOrderAct.startMyorderAct(getActivity(), MyOrderAct.ORDER_REQUEST_ALL);
//                break;
//            case R.id.tv_employee_list:   // 店员榜单
//                SalesmanRankingAct.start(getActivity());
//                break;
//            case R.id.btn_user_collect:
//                break;
//            case R.id.btn_ddyh:  //     客多多
//
//                ViewUtils.startActivity(new Intent(getActivity(), AllCustomerActivity.class),getActivity());
//
//                break;
//            case R.id.btn_user_topic://优惠领取清单
//
//                GetFavorableStatisticsAct.start(getActivity());
//                UmengUtil.onEvent(getActivity(), new UmengUtil().MANAGE_DISCOUNTRECEIVE_CLICK, null);
//                break;

//                if (Account.user.getRoleType() == Constants.USER_TYPE_ADMIN) {
//                    GetFavorableStatisticsAct.start(getActivity());
//                } else {
//                    EaseConstant.startBenefitsActivity(getActivity());
//                }
//                EaseConstant.startBenefitsActivity(getActivity());


            case R.id.ll_setting_user_name:  //     设置门店名

                ViewUtils.startActivity(new Intent(getActivity(), AliteSettingMyShopInfoActivity.class), getActivity());

                break;

            case R.id.layout_my_shop:  //  我的网店

                ViewUtils.startActivity(new Intent(getActivity(), AliteSettingMyShopInfoActivity.class), getActivity());

                break;


        }
    }

    @Override
    public void onShopInfoSuccessView(ShopInfoBase shopInfoBase) {
        //  获取门店信息返回

        Logger.t("YAG").d(shopInfoBase);
        String iconUrl = shopInfoBase.getIconUrl();
        if (StringUtil.isNull(iconUrl)) {
            imgUserHead.setImageResource(R.drawable.default_head_small);
        } else {
            imgUserHead.setImageUrl(iconUrl, R.drawable.default_head_small);
        }
        String name = shopInfoBase.getName();
        if (StringUtil.isNull(name)) {
            txtUserName.setText("未设置门店名");
        } else {
            txtUserName.setText(name);
        }


    }

    @Override
    public void onFailView(String errorMsg) {

    }
}
