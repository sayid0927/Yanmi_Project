package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCode;
import com.aliter.entity.Login;
import com.aliter.entity.LoginBean;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface LoginPresenter {
    interface View extends BaseView<LoginBean> {
//         void  getLogin(IMUserInfoVO imUserInfoVO);
//         void   getAuthCode(AuthCodeBean authCodeBean);

    }

    interface Presenter {
        void fetchLogin(Login login);
        void fetchgetAuthCode(AuthCode authCode);
    }
}
