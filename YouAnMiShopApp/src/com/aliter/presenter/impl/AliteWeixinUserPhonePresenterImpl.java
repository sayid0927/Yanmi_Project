package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitAuthCodeHttpUtils;
import com.aliter.presenter.AliteWeixinUserPhonePresenter;

import javax.inject.Inject;

public class AliteWeixinUserPhonePresenterImpl extends BasePresenter<AliteWeixinUserPhonePresenter.View> implements AliteWeixinUserPhonePresenter.Presenter {
    private RetrofitAuthCodeHttpUtils retrofitAuthCodeHttpUtils;

    @Inject
    public AliteWeixinUserPhonePresenterImpl(RetrofitAuthCodeHttpUtils retrofitAuthCodeHttpUtils) {
        this.retrofitAuthCodeHttpUtils = retrofitAuthCodeHttpUtils;
    }


    @Override
    public void fetchgetAuthCode(AuthCode authCode) {
        invoke(retrofitAuthCodeHttpUtils.fetchgetAuthCode(authCode),new Callback<BaseResponse<AuthCodeBean>>(){
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
