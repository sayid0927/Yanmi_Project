package com.aliter.presenter.impl;


import com.aliter.base.BasePresenter;
import com.aliter.entity.ShopInfo;
import com.aliter.entity.ShopInfoBase;
import com.aliter.http.BaseResponse;
import com.aliter.http.Callback;
import com.aliter.http.utils.MyStroeHttpUtils;
import com.aliter.presenter.MyStorePresenter;
import com.zxly.o2o.account.Account;

import javax.inject.Inject;

public class ShopInfoPresenterImpl extends BasePresenter<MyStorePresenter.View> implements MyStorePresenter.Presenter {
    private MyStroeHttpUtils myStroeHttpUtils;

    @Inject
    public ShopInfoPresenterImpl(MyStroeHttpUtils myStroeHttpUtils) {
        this.myStroeHttpUtils = myStroeHttpUtils;
    }


    @Override
    public void ShopInfo() {

        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(Account.user.getShopId());

        invoke(myStroeHttpUtils.ShopInfo(shopInfo), new Callback<BaseResponse<ShopInfoBase>>() {
            @Override
            public void onSuccess(BaseResponse<ShopInfoBase> data) {
                ShopInfoBase shopInfoBase =data.getData();
                if(shopInfoBase!=null){
                    mView.onShopInfoSuccessView(shopInfoBase);
                }else {
                    mView.onFailView("数据为空");
                }
            }

            @Override
            public void onFail(String msg) {mView.onFailView(msg);
            }
        });

    }
}
