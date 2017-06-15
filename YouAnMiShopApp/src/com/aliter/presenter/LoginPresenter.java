package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.entity.Login;
import com.aliter.entity.LoginBean;
import com.easemob.easeui.model.IMUserInfoVO;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface LoginPresenter {
    interface View extends BaseView<LoginBean> {
         void  onLoginSuccessView(IMUserInfoVO imUserInfoVO);
         void  onAuthCodeSuccessView(AuthCodeBean authCodeBean);
         void  onCheckAuthCodeSuccessView(CheckAuthCodeBean checkAuthCodeBean);
         void  onFailView(String errorMsg);//获取数据失败调用该方法。


    }

    interface Presenter {
        void fetchLogin(Login login);
        void fetchgetAuthCode(AuthCode authCode);
        void fetchCheckAuthCode(CheckAuthCode checkAuthCode);
    }
}
