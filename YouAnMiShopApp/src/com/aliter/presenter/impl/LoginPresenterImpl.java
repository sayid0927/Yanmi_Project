package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.Login;
import com.aliter.entity.LoginBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitLoginHttpUtils;
import com.aliter.presenter.LoginPresenter;
import com.easemob.easeui.model.IMUserInfoVO;

import javax.inject.Inject;

public class LoginPresenterImpl extends BasePresenter<LoginPresenter.View> implements LoginPresenter.Presenter {
    private RetrofitLoginHttpUtils retrofitLoginHttpUtils;

    @Inject
    public LoginPresenterImpl(RetrofitLoginHttpUtils retrofitLoginHttpUtils) {
        this.retrofitLoginHttpUtils = retrofitLoginHttpUtils;
    }

    @Override
    public void fetchLogin(Login login) {
        invoke(retrofitLoginHttpUtils.fetchLogin(login), new Callback<BaseResponse<IMUserInfoVO>>() {
            @Override
            public void onSuccess(BaseResponse<IMUserInfoVO> data) {
                LoginBean loginBean = new LoginBean();
                loginBean.setImUserInfoVO(data.getData());
                mView.onSuccessView(loginBean);


            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    @Override
    public void fetchgetAuthCode(AuthCode authCode) {
      invoke(retrofitLoginHttpUtils.getAuthCode(authCode), new Callback<BaseResponse<AuthCodeBean>>() {
          @Override
          public void onSuccess(BaseResponse<AuthCodeBean> data) {

          }

          @Override
          public void onFail(String msg) {

          }
      });
    }

//    @Override
//    public void fetchLogin(Login login) {
//        invoke(retrofitLoginHttpUtils.fetchLogin(login),new Callback<BaseResponse<LoginBean.IMUserInfoVO>>(){
//            @Override
//            public void onSuccess(BaseResponse<IMUserInfoVO> data) {
//                mView.onSuccessView(data);
//            }
//
//            @Override
//            public void onFail(String msg) {
//                    mView.onFailView(msg);
//            }
//        });
//    }
//
//    @Override
//    public void fetchgetAuthCode(AuthCode authCode) {
//        invoke(retrofitLoginHttpUtils.getAuthCode(authCode), new Callback<BaseResponse<AuthCodeBean>>() {
//            @Override
//            public void onSuccess(BaseResponse<AuthCodeBean> data) {
//                mView.onSuccessView(data);
//            }
//
//            @Override
//            public void onFail(String msg) {
//                mView.onFailView(msg);
//            }
//        });
//    }
}
