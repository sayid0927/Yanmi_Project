package com.aliter.ui.fragment;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.aliter.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.yongchun.library.view.ImageSelectorActivity;
import com.zxly.o2o.activity.SettingAct;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.shop.R;
import com.zxly.o2o.util.CallBack;
import com.zxly.o2o.util.PhoneUtil;
import com.zxly.o2o.view.CircleImageView;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

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

    public  static  SelfFragmentAlite install =null;



    @Override
    protected void loadData() {
        setState(AppController.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.alite_fragment_self;
    }

    @Override
    protected void initView() {
       install=this;
    }

    @Override
    protected void initInject() {

    }


    @OnClick({R.id.ll_setting, R.id.rl_service_phone,R.id.img_user_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_setting:
                SettingAct.start(getActivity(), new CallBack() {
                    @Override
                    public void onCall() {
                        getActivity().finish();
                    }
                });

                break;

            case R.id.rl_service_phone:

                PhoneUtil.openPhoneKeyBord("4008774567", getActivity());

                break;
            case  R.id.img_user_head:
                ImageSelectorActivity.start(getActivity(), 1, 2, true,true,true);
                break;
        }
    }

  public  void  setImgUserHead(ArrayList<String> images ) {
      if (images.size() !=0) {
          Glide.with(getActivity())
                  .load(new File(images.get(0)))
                  .into(imgUserHead);
      }
  }
}

