package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.ShopAppMenu;
import com.aliter.entity.ShopAppMenuBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.RetrofitHomeActivityHttpUtils;
import com.aliter.presenter.HomeActivityPresenter;

import javax.inject.Inject;

public class HomeActivityPresenterImpl extends BasePresenter<HomeActivityPresenter.View> implements HomeActivityPresenter.Presenter {
    private RetrofitHomeActivityHttpUtils retrofitHomeActivityHttpUtils;

    @Inject
    public HomeActivityPresenterImpl(RetrofitHomeActivityHttpUtils retrofitHomeActivityHttpUtils) {
        this.retrofitHomeActivityHttpUtils = retrofitHomeActivityHttpUtils;
    }

    @Override
    public void ShopAppMenu(final ShopAppMenu shopAppMenu) {

        invoke(retrofitHomeActivityHttpUtils.fetch(shopAppMenu), new Callback<BaseResponse<ShopAppMenuBean>>() {
            @Override
            public void onSuccess(BaseResponse<ShopAppMenuBean> data) {
                ShopAppMenuBean shopAppMenuBean =data.getData();

                if(shopAppMenuBean!=null){
                    mView.onShopAppMenuSuccessView(shopAppMenuBean);
                }else {
                    mView.onFailView("数据为空");
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }


}
