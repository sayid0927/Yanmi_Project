package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface AliteForgetPwdPresenter {
    interface View extends BaseView<AuthCodeBean> {
        void  onAuthCodeSuccessView(AuthCodeBean forgetPwdAuthCodeBean);
        void  onBackPwdSuccessView(CheckAuthCodeBean checkAuthCodeBean);
        void  onFailView(String errorMsg);//获取数据失败调用该方法。

    }
    interface Presenter {
        void fetchgetAuthCode(AuthCode authCode);
        void fetchCheckAuthCode(CheckAuthCode checkAuthCode);
    }
}
