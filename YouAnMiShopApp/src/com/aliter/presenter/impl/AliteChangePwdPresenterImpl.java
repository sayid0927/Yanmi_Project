package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.ShopSetPassword2;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitShopSetPassword2HttpUtils;
import com.aliter.presenter.AliteChangePwdPresenter;

import javax.inject.Inject;

public class AliteChangePwdPresenterImpl extends BasePresenter<AliteChangePwdPresenter.View> implements AliteChangePwdPresenter.Presenter {
    private RetrofitShopSetPassword2HttpUtils retrofitShopSetPassword2HttpUtils;

    @Inject
    public AliteChangePwdPresenterImpl(RetrofitShopSetPassword2HttpUtils retrofitShopSetPassword2HttpUtils) {
        this.retrofitShopSetPassword2HttpUtils = retrofitShopSetPassword2HttpUtils;
    }


    @Override
    public void ShopSetPassword2(ShopSetPassword2 shopSetPassword2) {
        invoke(retrofitShopSetPassword2HttpUtils.ShopSetPassword2(shopSetPassword2), new Callback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse data) {
                if(data!=null){

                    mView.onShopSetPassword2SuccessView();
                }
            }

            @Override
            public void onFail(String msg) {
mView.onFailView(msg);
            }

        });
    }
}
