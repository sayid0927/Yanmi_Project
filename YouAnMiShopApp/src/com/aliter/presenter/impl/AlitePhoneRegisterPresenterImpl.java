package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
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
    public void ShopAppisMobileExist(MobileExist mobileExist) {
        invoke(retrofitPhoneRegisterHttpUtils.ShopAppisMobileExist(mobileExist),new Callback<BaseResponse<MobileExistBean>>(){
            @Override
            public void onSuccess(BaseResponse<MobileExistBean> data) {
                MobileExistBean mobileExistBean = data.getData();
                if(mobileExistBean!=null)
                    mView.onShopAppisMobileExistSuccessView(mobileExistBean);
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
