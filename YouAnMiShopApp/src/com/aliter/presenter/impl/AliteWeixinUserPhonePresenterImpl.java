package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitWeixinUserPhoneHttpUtils;
import com.aliter.presenter.AliteWeixinUserPhonePresenter;

import javax.inject.Inject;

public class AliteWeixinUserPhonePresenterImpl extends BasePresenter<AliteWeixinUserPhonePresenter.View> implements AliteWeixinUserPhonePresenter.Presenter {
    private RetrofitWeixinUserPhoneHttpUtils retrofitWeixinUserPhoneHttpUtils;

    @Inject
    public AliteWeixinUserPhonePresenterImpl(RetrofitWeixinUserPhoneHttpUtils retrofitWeixinUserPhoneHttpUtils) {
        this.retrofitWeixinUserPhoneHttpUtils = retrofitWeixinUserPhoneHttpUtils;
    }


    @Override
    public void fetchgetAuthCode(AuthCode authCode) {
        invoke(retrofitWeixinUserPhoneHttpUtils.getAuthCode(authCode),new Callback<BaseResponse<AuthCodeBean>>(){
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

    @Override
    public void fetchCheckAuthCode(CheckAuthCode checkAuthCode) {
        invoke(retrofitWeixinUserPhoneHttpUtils.getCheckAuthCode(checkAuthCode),new Callback<BaseResponse<CheckAuthCodeBean>>(){
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
}
