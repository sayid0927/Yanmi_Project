package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.Login;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitWeixinUserPhoneHttpUtils;
import com.aliter.presenter.AliteWeixinUserPhonePresenter;
import com.easemob.easeui.model.IMUserInfoVO;

import javax.inject.Inject;

public class AliteWeixinUserPhonePresenterImpl extends BasePresenter<AliteWeixinUserPhonePresenter.View> implements AliteWeixinUserPhonePresenter.Presenter {
    private RetrofitWeixinUserPhoneHttpUtils retrofitWeixinUserPhoneHttpUtils;

    @Inject
    public AliteWeixinUserPhonePresenterImpl(RetrofitWeixinUserPhoneHttpUtils retrofitWeixinUserPhoneHttpUtils) {
        this.retrofitWeixinUserPhoneHttpUtils = retrofitWeixinUserPhoneHttpUtils;
    }

    @Override
    public void ShopAppisMobileExist(final MobileExist mobileExist) {
        invoke(retrofitWeixinUserPhoneHttpUtils.ShopAppisMobileExist(mobileExist), new Callback<BaseResponse<MobileExistBean>>() {
            @Override
            public void onSuccess(BaseResponse<MobileExistBean> data) {
                MobileExistBean mobileExistBean = data.getData();
                if (mobileExistBean != null) {
                    mView.onShopAppisMobileExistSuccessView(mobileExistBean);
                } else {
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
    public void ShopGetSecurityCod(AuthCode authCode) {
        invoke(retrofitWeixinUserPhoneHttpUtils.ShopGetSecurityCode(authCode), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
                if (data != null) {
                    mView.onShopGetSecurityCodeSuccessView();
                } else {
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
    public void ShopAPPCheckSecurityCode(CheckAuthCode checkAuthCode) {
        invoke(retrofitWeixinUserPhoneHttpUtils.ShopAPPCheckSecurityCode(checkAuthCode), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
                if (data != null) {
                    mView.onShopAPPCheckSecurityCodeSuccessView();
                } else {
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
    public void AuthShopLogin2(Login login) {
        invoke(retrofitWeixinUserPhoneHttpUtils.AuthShopLogin2(login), new Callback<BaseResponse<IMUserInfoVO>>() {
            @Override
            public void onSuccess(BaseResponse<IMUserInfoVO> data) {
                IMUserInfoVO imUserInfoVO = data.getData();
                if (imUserInfoVO != null) {
                    mView.onAuthShopLogin2SuccessView(imUserInfoVO);
                } else {
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
