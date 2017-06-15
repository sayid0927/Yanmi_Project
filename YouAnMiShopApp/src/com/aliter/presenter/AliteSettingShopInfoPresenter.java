package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.ShopRegister;
import com.easemob.easeui.model.IMUserInfoVO;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface AliteSettingShopInfoPresenter {
    interface View extends BaseView<IMUserInfoVO> {
        void  onShopRegisterSuccessView(IMUserInfoVO imUserInfoVO);
        void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }
    interface Presenter {
        void fetchShopRegister(ShopRegister shopRegister);
    }
}
