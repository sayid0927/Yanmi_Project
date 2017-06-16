package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.Login;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.LoginService;
import com.easemob.easeui.model.IMUserInfoVO;

import rx.Observable;



public class RetrofitLoginHttpUtils extends HttpUtils {

    private LoginService loginService;

    public RetrofitLoginHttpUtils(LoginService loginService) {
        this.loginService = loginService;
    }

    public Observable<BaseResponse<IMUserInfoVO>> fetchLogin(Login login) {
       return loginService.getLogin(login);
    }

    public Observable<BaseResponse > ShopGetSecurityCode(AuthCode authCode) {
        return loginService.ShopGetSecurityCode(authCode);
    }

}
