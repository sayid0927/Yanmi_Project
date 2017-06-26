package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.ShopAppMenu;
import com.aliter.entity.ShopAppMenuBean;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface HomeActivityPresenter {
    interface View extends BaseView {
         void  onShopAppMenuSuccessView(ShopAppMenuBean shopAppMenuBean);
         void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }

    interface Presenter {
        void ShopAppMenu(ShopAppMenu shopAppMenu);
    }
}
