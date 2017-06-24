package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.ShopInfoBase;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface MyStorePresenter {
    interface View extends BaseView {
         void  onShopInfoSuccessView(ShopInfoBase shopInfoBase);
         void  onFailView(String errorMsg);//获取数据失败调用该方法。



    }

    interface Presenter {
        void ShopInfo();
    }
}
