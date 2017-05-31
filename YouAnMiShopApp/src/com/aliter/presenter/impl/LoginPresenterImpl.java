package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.Login;
import com.aliter.entity.LoginBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitLoginHttpUtils;
import com.aliter.presenter.LoginPresenter;

import javax.inject.Inject;

public class LoginPresenterImpl extends BasePresenter<LoginPresenter.View> implements LoginPresenter.Presenter {
    private RetrofitLoginHttpUtils retrofitLoginHttpUtils;

    @Inject
    public LoginPresenterImpl(RetrofitLoginHttpUtils retrofitLoginHttpUtils) {
        this.retrofitLoginHttpUtils = retrofitLoginHttpUtils;
    }

    @Override
    public void fetchLogin(Login login) {
        invoke(retrofitLoginHttpUtils.fetchLogin(login),new Callback<BaseResponse<LoginBean>>(){
            @Override
            public void onSuccess(BaseResponse<LoginBean> data) {
                mView.onSuccessView(data);
            }

            @Override
            public void onFail(String msg) {
                    mView.onFailView(msg);
            }
        });
    }
}
