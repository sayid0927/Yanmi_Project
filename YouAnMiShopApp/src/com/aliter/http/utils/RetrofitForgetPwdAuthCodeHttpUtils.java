package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.ForgetPwdAuthCodeService;

import rx.Observable;


public class RetrofitForgetPwdAuthCodeHttpUtils extends HttpUtils {

    private ForgetPwdAuthCodeService forgetPwdAuthCodeService;

    public RetrofitForgetPwdAuthCodeHttpUtils(ForgetPwdAuthCodeService forgetPwdAuthCodeService) {
        this.forgetPwdAuthCodeService = forgetPwdAuthCodeService;
    }

    public Observable<BaseResponse> ShopGetSecurityCode(AuthCode authCode) {
       return forgetPwdAuthCodeService.ShopGetSecurityCode(authCode);
    }

    public Observable<BaseResponse > ShopAppCheckSecurityCode(CheckAuthCode checkAuthCode) {
        return forgetPwdAuthCodeService.ShopAppCheckSecurityCode(checkAuthCode);
    }

}
