package com.aliter.ui.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliter.base.BaseFragment;
import com.aliter.ui.activity.self.AliteMeakeMoneyActivity;
import com.zxly.o2o.account.Account;
import com.zxly.o2o.activity.FeedbackAct;
import com.zxly.o2o.activity.FragmentListAct;
import com.zxly.o2o.activity.PayMyAccountAct;
import com.zxly.o2o.activity.PersonalHomepageAct;
import com.zxly.o2o.activity.SettingAct;
import com.zxly.o2o.activity.YieldDetailAct;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.request.BaseRequest;
import com.zxly.o2o.request.MakeMoneyInitRequest;
import com.zxly.o2o.request.PersonalInitRequest;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.CallBack;
import com.zxly.o2o.util.PhoneUtil;
import com.zxly.o2o.util.StringUtil;
import com.zxly.o2o.util.UmengUtil;
import com.zxly.o2o.util.ViewUtils;
import com.zxly.o2o.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by sayid on 2017/6/2.
 */

public class SelfFragmentAlite extends BaseFragment {
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;
    @BindView(R.id.rl_service_phone)
    RelativeLayout btnServicePhone;
    @BindView(R.id.img_user_head)
    CircleImageView imgUserHead;

    @BindView(R.id.ll_earnings_list)
    LinearLayout llEarningsList;
    @BindView(R.id.rl_task_index)
    RelativeLayout rlTaskIndex;
    @BindView(R.id.ll_my_messages)
    LinearLayout llMyMessages;
    @BindView(R.id.rl_user_balance)
    RelativeLayout rlUserBalance;
    @BindView(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    @BindView(R.id.ll_setting_user_name)
    LinearLayout llSettingUserName;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    public static SelfFragmentAlite install;
    @BindView(R.id.txt_user_balance)
    TextView txtUserBalance;
    @BindView(R.id.rl_meake_money)
    RelativeLayout rlMeakeMoney;
    @BindView(R.id.tv_accumulative_earnings_num)
    TextView tvAccumulativeEarningsNum;
    @BindView(R.id.tv_accumulative_earnings)
    TextView tvAccumulativeEarnings;
    Unbinder unbinder;
    @BindView(R.id.tv_month_earnings_num)
    TextView tvMonthEarningsNum;

    private MakeMoneyInitRequest moneyInitRequest;


    private PersonalInitRequest personalInitRequest;

    @Override
    protected void loadData() {
        personalInitRequest = new PersonalInitRequest(Account.user.getId(), Account.user.getShopId(), 0, 0);
        personalInitRequest.setOnResponseStateListener(new BaseRequest.ResponseStateListener() {

            @Override
            public void onOK() {
                float userBalance = personalInitRequest.getAccountBalance();
                ViewUtils.setTextPrice(txtUserBalance, userBalance);

            }

            @Override
            public void onFail(int code) {

            }
        });
        personalInitRequest.start(this);
        setState(AppController.STATE_SUCCESS);
    }


    @Override

    protected int getLayoutId() {
        return R.layout.alite_fragment_self;
    }

    @Override
    protected void initView() {
        setImgUserHead();
        install = this;
        MakeMoneyinit();
    }

    @Override
    protected void initInject() {

    }

    public void setImgUserHead() {
        String thumHeadUrl = Account.user.getThumHeadUrl();
        if (StringUtil.isNull(thumHeadUrl)) {
            imgUserHead.setImageResource(R.drawable.default_head_small);
        } else {
            imgUserHead.setImageUrl(thumHeadUrl, R.drawable.default_head_small);
        }
        String curNick = Account.user.getNickname();
        if (StringUtil.isNull(curNick)) {
            txtUserName.setText("未设置昵称");
        } else {
            txtUserName.setText(curNick);
        }
    }


    @OnClick({R.id.ll_setting, R.id.rl_service_phone, R.id.img_user_head, R.id.ll_earnings_list, R.id.rl_task_index,
            R.id.ll_my_messages, R.id.rl_user_balance, R.id.rl_feedback, R.id.ll_setting_user_name, R.id.rl_meake_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_setting:    //  设置
                SettingAct.start(getActivity(), new CallBack() {
                    @Override
                    public void onCall() {
                        getActivity().finish();
                    }
                });

                break;

            case R.id.rl_service_phone:  //  客服电话
                createLogoutDialog();
                break;

            case R.id.rl_meake_money:  //  赚钱攻略
                ViewUtils.startActivity(new Intent(getActivity(), AliteMeakeMoneyActivity.class), getActivity());

                break;

            case R.id.img_user_head:
                break;

            case R.id.ll_earnings_list: //  收益明细
                YieldDetailAct.start(this.getActivity());
                break;

            case R.id.rl_task_index: //  任务指标
                FragmentListAct.start("任务指标", FragmentListAct.PAGE_TASK_TARGET);
                break;
            case R.id.ll_my_messages: //  我的消息
                FragmentListAct.start("我的消息", FragmentListAct.PAGE_GUARANTEE_MSG);
                UmengUtil.onEvent(getActivity(), new UmengUtil().MY_MESSAGE_CLICK, null);
                break;

            case R.id.rl_user_balance: //  我的帐户余额
                PayMyAccountAct.start(getActivity());
                UmengUtil.onEvent(getActivity(), new UmengUtil().MY_BALANCE_CLICK, null);
                break;
            case R.id.rl_feedback: //  用户反馈
                FeedbackAct.start(getActivity());
                UmengUtil.onEvent(getActivity(), new UmengUtil().MY_FEEDBACK_CLICK, null);
                break;

            case R.id.ll_setting_user_name: //  设置用户信息
                PersonalHomepageAct.start(getActivity());
                break;

        }
    }

    private Dialog dialog;

    private void createLogoutDialog() {
        if (dialog == null) {
            dialog = new Dialog(getActivity(), R.style.dialog);
        }
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog.show();
        dialog.setContentView(R.layout.dialog_logout);
        dialog.findViewById(R.id.tv_phone_num).setVisibility(View.VISIBLE);
        TextView textView = (TextView) dialog.findViewById(R.id.txt_title);
        textView.setText("4008774567");
        dialog.findViewById(R.id.btn_done)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                            PhoneUtil.openPhoneKeyBord("4008774567", getActivity());
                        }
                    }
                });
        dialog.findViewById(R.id.btn_cancel)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }
                });
    }


    private void MakeMoneyinit() {
        moneyInitRequest = new MakeMoneyInitRequest();
        moneyInitRequest.setOnResponseStateListener(new BaseRequest.ResponseStateListener() {
            @Override
            public void onOK() {
                ViewUtils.setTextPric(tvAccumulativeEarningsNum, moneyInitRequest.getAllRevenue());
                tvMonthEarningsNum.setText(StringUtil.getFormatPrice(moneyInitRequest.getCurrentMonthRevenue()));
            }

            @Override
            public void onFail(int code) {
            }
        });
        moneyInitRequest.start(this);
    }
}

