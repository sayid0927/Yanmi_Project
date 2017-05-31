package com.aliter.http.utils;


import com.aliter.entity.Login;
import com.aliter.entity.LoginBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.LoginService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class RetrofitLoginHttpUtils extends HttpUtils {

    private LoginService loginService;

    public RetrofitLoginHttpUtils(LoginService loginService) {
        this.loginService = loginService;
    }

    public Observable<BaseResponse<LoginBean>> fetchLogin(Login login) {
       return loginService.getLogin(login);
    }
}
