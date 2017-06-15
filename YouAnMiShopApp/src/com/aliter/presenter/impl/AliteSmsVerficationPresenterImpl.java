package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
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
    public void fetchgetAuthCode(CheckAuthCode checkAuthCode) {
        invoke(smsVerificationHttpUtils.fetchCheckAuthCode(checkAuthCode),new Callback<BaseResponse<CheckAuthCodeBean>>(){
            @Override
            public void onSuccess(BaseResponse<CheckAuthCodeBean> data) {
                CheckAuthCodeBean authCodeBean = data.getData();
                if(authCodeBean!=null)
                    mView.onCheckAuthCodeSuccessView(authCodeBean);
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
    public void fetAuthCode(AuthCode authCode) {
        invoke(smsVerificationHttpUtils.fetchgetAuthCode(authCode),new Callback<BaseResponse<AuthCodeBean>>(){
            @Override
            public void onSuccess(BaseResponse<AuthCodeBean> data) {
                AuthCodeBean authCodeBean = data.getData();
                if(authCodeBean!=null)
                    mView.onAuthCodeSuccessView(authCodeBean);
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
