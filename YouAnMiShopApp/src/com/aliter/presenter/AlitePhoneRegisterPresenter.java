package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface AlitePhoneRegisterPresenter {
    interface View extends BaseView<AuthCodeBean> {
        void   onShopAppisMobileExistSuccessView(MobileExistBean mobileExistBean);
        void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }
    interface Presenter {
        void  ShopAppisMobileExist(MobileExist mobileExist);
    }
}
