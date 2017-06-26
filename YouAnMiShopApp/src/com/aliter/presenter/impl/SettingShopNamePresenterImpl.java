package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.ShopUpdate;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.SettingShopNameHttpUtils;
import com.aliter.presenter.SettingShopNamePresenter;

import javax.inject.Inject;

import okhttp3.MultipartBody;

public class SettingShopNamePresenterImpl extends BasePresenter<SettingShopNamePresenter.View> implements SettingShopNamePresenter.Presenter {
    private SettingShopNameHttpUtils settingShopNameHttpUtils;

    @Inject
    public SettingShopNamePresenterImpl(SettingShopNameHttpUtils settingShopNameHttpUtils) {
        this.settingShopNameHttpUtils = settingShopNameHttpUtils;
    }

    @Override
    public void CommonImageUpload(MultipartBody.Part file) {
        invoke(settingShopNameHttpUtils.CommonImageUpload(file), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
                if (data != null) {
                    mView.onCommonImageUploadSuccessView();
                } else {
                    mView.onFailView("数据为空");
                }
            }

            @Override
            public void onFail(String msg) {
                mView.onFailView(msg);
            }
        });
    }

    @Override
    public void ShopUpdate(ShopUpdate shopUpdate) {
        invoke(settingShopNameHttpUtils.ShopUpdate(shopUpdate), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
                if (data != null) {
                    mView.onShopUpdateSuccessView();
                } else {
                    mView.onFailView("数据为空");
                }
            }

            @Override
            public void onFail(String msg) {
                mView.onFailView(msg);
            }
        });
    }
}
