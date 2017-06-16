package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitForgetPwdAuthCodeHttpUtils;
import com.aliter.presenter.AliteForgetPwdPresenter;

import javax.inject.Inject;

public class AliteForgetPwdPresenterImpl extends BasePresenter<AliteForgetPwdPresenter.View> implements AliteForgetPwdPresenter.Presenter {
    private RetrofitForgetPwdAuthCodeHttpUtils retrofitForgetPwdAuthCodeHttpUtils;

    @Inject
    public AliteForgetPwdPresenterImpl(RetrofitForgetPwdAuthCodeHttpUtils retrofitForgetPwdAuthCodeHttpUtils) {
        this.retrofitForgetPwdAuthCodeHttpUtils = retrofitForgetPwdAuthCodeHttpUtils;
    }


    @Override
    public void ShopGetSecurityCode(AuthCode authCode) {
        invoke(retrofitForgetPwdAuthCodeHttpUtils.ShopGetSecurityCode(authCode), new Callback<BaseResponse<AuthCodeBean>>() {
            @Override
            public void onSuccess(BaseResponse<AuthCodeBean> data) {
                if(data!=null){
                    mView.onShopGetSecurityCodeSuccessView();
                }else {
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
    public void ShopAppCheckSecurityCode(CheckAuthCode checkAuthCode) {
        invoke(retrofitForgetPwdAuthCodeHttpUtils.ShopAppCheckSecurityCode(checkAuthCode), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
                if(data!=null){
                    mView.onShopAppCheckSecurityCodeSuccessView();
                }else {
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
