package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;


/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface AliteWeixinUserPhonePresenter {
    interface View extends BaseView<AuthCodeBean> {
    }
    interface Presenter {
        void fetchgetAuthCode(AuthCode authCode);
    }
}
