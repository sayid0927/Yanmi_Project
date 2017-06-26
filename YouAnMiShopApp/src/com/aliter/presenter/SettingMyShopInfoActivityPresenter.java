package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.ShopUpdate;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface SettingMyShopInfoActivityPresenter {
    interface View extends BaseView {
         void  onShopUpdateSuccessView();
         void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }

    interface Presenter {
        void ShopUpdate(ShopUpdate shopUpdate );
    }
}
