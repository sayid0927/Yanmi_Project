package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCode;
import com.aliter.entity.Login;
import com.easemob.easeui.model.IMUserInfoVO;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface LoginPresenter {
    interface View extends BaseView {
         void  onAuthShopLogin2SuccessView(IMUserInfoVO imUserInfoVO);
         void  onShopGetSecurityCodeSuccessView();
         void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }

    interface Presenter {
        void AuthShopLogin2(Login login);
        void ShopGetSecurityCode(AuthCode authCode);
    }
}
