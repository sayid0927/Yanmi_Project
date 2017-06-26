package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.ShopUpdate;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.SettingMyShopInfoHttpUtils;
import com.aliter.presenter.SettingMyShopInfoActivityPresenter;

import javax.inject.Inject;

public class SettingMyShopInfoActivityPresenterImpl extends BasePresenter<SettingMyShopInfoActivityPresenter.View> implements SettingMyShopInfoActivityPresenter.Presenter {
    private SettingMyShopInfoHttpUtils settingMyShopInfoHttpUtils;

    @Inject
    public SettingMyShopInfoActivityPresenterImpl(SettingMyShopInfoHttpUtils settingMyShopInfoHttpUtils) {
        this.settingMyShopInfoHttpUtils = settingMyShopInfoHttpUtils;
    }


    @Override
    public void ShopUpdate(ShopUpdate shopUpdate) {
        invoke(settingMyShopInfoHttpUtils.ShopUpdate(shopUpdate), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
                if(data!=null)
                    mView.onShopUpdateSuccessView();
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
