package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface AliteForgetPwdPresenter {
    interface View extends BaseView {
        void  onShopGetSecurityCodeSuccessView();
        void  onShopAppCheckSecurityCodeSuccessView();
        void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }
    interface Presenter {
        void ShopGetSecurityCode(AuthCode authCode);
        void ShopAppCheckSecurityCode(CheckAuthCode checkAuthCode);
    }
}
