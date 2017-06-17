package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.SmsVerificationHttpUtils;
import com.aliter.presenter.AliteSmsVerificationPresenter;

import javax.inject.Inject;

public class AliteSmsVerficationPresenterImpl extends BasePresenter<AliteSmsVerificationPresenter.View> implements AliteSmsVerificationPresenter.Presenter {
    private SmsVerificationHttpUtils smsVerificationHttpUtils;

    @Inject
    public AliteSmsVerficationPresenterImpl(SmsVerificationHttpUtils smsVerificationHttpUtils) {
        this.smsVerificationHttpUtils = smsVerificationHttpUtils;
    }



    @Override
    public void ShopAPPCheckSecurityCode(CheckAuthCode checkAuthCode) {
        invoke(smsVerificationHttpUtils.shopAPPCheckSecurityCode(checkAuthCode),new Callback<BaseResponse>(){
            @Override
            public void onSuccess(BaseResponse data) {
                if(data!=null)
                    mView.onShopAPPCheckSecurityCodeSuccessView();
                else
                    mView.onFailView("数据为空");
            }
            @Override
            public void onFail(String msg) {
                mView.onFailView(msg);
            }

        });


    }

    @Override
    public void ShopgetSecurityCode(AuthCode authCode) {
        invoke(smsVerificationHttpUtils.ShopgetSecurityCode(authCode),new Callback<BaseResponse>(){
            @Override
            public void onSuccess(BaseResponse data) {
                if(data!=null)
                    mView.onShopgetSecurityCodeSuccessView();
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
