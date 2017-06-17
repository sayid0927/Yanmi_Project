package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.ShopRegister;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.SettingShopInfoHttpUtils;
import com.aliter.presenter.AliteSettingShopInfoPresenter;
import com.easemob.easeui.model.IMUserInfoVO;

import javax.inject.Inject;

public class AliteSettingShopInfoPresenterImpl extends BasePresenter<AliteSettingShopInfoPresenter.View> implements AliteSettingShopInfoPresenter.Presenter {
    private SettingShopInfoHttpUtils settingShopInfoHttpUtils;

    @Inject
    public AliteSettingShopInfoPresenterImpl(SettingShopInfoHttpUtils settingShopInfoHttpUtils) {
        this.settingShopInfoHttpUtils = settingShopInfoHttpUtils;
    }

    @Override
    public void fetchShopRegister(ShopRegister shopRegister) {
        invoke(settingShopInfoHttpUtils.shopRegister(shopRegister), new Callback<BaseResponse<IMUserInfoVO>>() {
            @Override
            public void onSuccess(BaseResponse<IMUserInfoVO> data) {
                IMUserInfoVO userInfoVO =data.getData();
                if(userInfoVO!=null)
                    mView.onShopRegisterSuccessView(userInfoVO);
                else
                    mView.onFailView("数据为空");
            }

            @Override
            public void onFail(String msg) {
                   mView.onFailView(msg);
            }
        });
    }
}
