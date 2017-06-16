package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.ShopSetPassword2;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface AliteChangePwdPresenter {
    interface View extends BaseView {
        void  onShopSetPassword2SuccessView();
        void  onFailView(String errorMsg);//获取数据失败调用该方法。
    }
    interface Presenter {
        void ShopSetPassword2(ShopSetPassword2 shopSetPassword2);

    }
}
