package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitPhoneRegisterHttpUtils;
import com.aliter.presenter.AlitePhoneRegisterPresenter;

import javax.inject.Inject;

public class AlitePhoneRegisterPresenterImpl extends BasePresenter<AlitePhoneRegisterPresenter.View> implements AlitePhoneRegisterPresenter.Presenter {
    private RetrofitPhoneRegisterHttpUtils retrofitPhoneRegisterHttpUtils;

    @Inject
    public AlitePhoneRegisterPresenterImpl(RetrofitPhoneRegisterHttpUtils retrofitPhoneRegisterHttpUtils) {
        this.retrofitPhoneRegisterHttpUtils = retrofitPhoneRegisterHttpUtils;
    }


    @Override
    public void fetchgetAuthCode(AuthCode authCode) {
        invoke(retrofitPhoneRegisterHttpUtils.fetchgetPhoneRegisterAuthCode(authCode),new Callback<BaseResponse<AuthCodeBean>>(){
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
