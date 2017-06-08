package com.aliter.presenter;


import com.aliter.base.BaseView;
import com.aliter.entity.Login;
import com.easemob.easeui.model.IMUserInfoVO;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface LoginPresenter {
    interface View extends BaseView<IMUserInfoVO> {
    }
    interface Presenter {
        void fetchLogin(Login login);
    }
}
