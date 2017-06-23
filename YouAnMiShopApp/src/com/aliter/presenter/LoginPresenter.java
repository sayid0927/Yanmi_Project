package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.easemob.easeui.model.IMUserInfoVO;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface LoginPresenter {
    interface View extends BaseView {
         void  onAuthShopLogin2SuccessView(IMUserInfoVO imUserInfoVO);
         void  onShopGetSecurityCodeSuccessView();
         void  onFailView(String errorMsg);//获取数据失败调用该方法。

         String getUsername();
         String getPassword();
         int getLoginType();

    }

    interface Presenter {
        void AuthShopLogin2();
        void ShopGetSecurityCode();
    }
}
