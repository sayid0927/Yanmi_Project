package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.Login;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.easemob.easeui.model.IMUserInfoVO;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface AliteWeixinUserPhonePresenter {
    interface View extends BaseView {
        void onShopGetSecurityCodeSuccessView();

        void onShopAPPCheckSecurityCodeSuccessView();

        void onShopAppisMobileExistSuccessView(MobileExistBean mobileExistBean);

        void onAuthShopLogin2SuccessView(IMUserInfoVO imUserInfoVO);
        void onFailView(String errorMsg);//获取数据失败调用该方法。

    }

    interface Presenter {
        void ShopAppisMobileExist(MobileExist mobileExist);

        void ShopGetSecurityCod(AuthCode authCode);

        void ShopAPPCheckSecurityCode(CheckAuthCode checkAuthCode);

        void AuthShopLogin2(Login login);
    }
}
