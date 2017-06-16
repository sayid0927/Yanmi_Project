package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.Login;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitLoginHttpUtils;
import com.aliter.presenter.LoginPresenter;
import com.blankj.utilcode.utils.StringUtils;
import com.easemob.chatuidemo.HXConstant;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.application.AppController;
import com.zxly.o2o.application.Config;
import com.zxly.o2o.util.DESUtils;
import com.zxly.o2o.util.EncryptionUtils;
import com.zxly.o2o.util.PreferUtil;

import javax.inject.Inject;

public class LoginPresenterImpl extends BasePresenter<LoginPresenter.View> implements LoginPresenter.Presenter {
    private RetrofitLoginHttpUtils retrofitLoginHttpUtils;

    @Inject
    public LoginPresenterImpl(RetrofitLoginHttpUtils retrofitLoginHttpUtils) {
        this.retrofitLoginHttpUtils = retrofitLoginHttpUtils;
    }

    @Override
    public void AuthShopLogin2(Login login) {
        invoke(retrofitLoginHttpUtils.fetchLogin(login), new Callback<BaseResponse<IMUserInfoVO>>() {
            @Override
            public void onSuccess(BaseResponse<IMUserInfoVO> data) {
                IMUserInfoVO imUserInfoVO = data.getData();
                if (imUserInfoVO != null) {

                    if (!StringUtils.isEmpty(imUserInfoVO.getSignKey())) {
                        try {
                            Config.accessKey = DESUtils.decrypt(imUserInfoVO.getSignKey(), Config.USER_SIGN_KEY);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!StringUtils.isEmpty(imUserInfoVO.getToken()))
                        PreferUtil.getInstance().setLoginToken(imUserInfoVO.getToken());
                    HXConstant.isLoginSuccess = true; //标识登录hx成功
                    AppController.getInstance().initHXAccount(imUserInfoVO, true);   //登录环信
                    imUserInfoVO.setPassword(EncryptionUtils.md5TransferPwd(imUserInfoVO.getPassword()));
                    imUserInfoVO.setUserName(imUserInfoVO.getName());


                    mView.onAuthShopLogin2SuccessView(imUserInfoVO);
                }
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
    public void ShopGetSecurityCode(AuthCode authCode) {
        invoke(retrofitLoginHttpUtils.ShopGetSecurityCode(authCode), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
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
}
