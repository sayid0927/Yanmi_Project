package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
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
    public void fetchgetAuthCode(AuthCode forgetPwdAuthCode) {
        invoke(retrofitForgetPwdAuthCodeHttpUtils.fetchgetForgetPwdAuthCode(forgetPwdAuthCode),new Callback<BaseResponse<AuthCodeBean>>(){
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
        invoke(retrofitForgetPwdAuthCodeHttpUtils.getCheckAuthCode(checkAuthCode), new Callback<BaseResponse<CheckAuthCodeBean>>() {
            @Override
            public void onSuccess(BaseResponse<CheckAuthCodeBean> data) {
                CheckAuthCodeBean checkAuthCodeBean = data.getData();
                if (checkAuthCodeBean != null) {
                    mView.onBackPwdSuccessView(checkAuthCodeBean);
                } else
                    mView.onFailView("数据为空");
            }
            @Override
            public void onFail(String msg) {
                mView.onFailView(msg);
            }
        });
    }
}
