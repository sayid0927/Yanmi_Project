package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.ForgetPwdAuthCodeService;

import rx.Observable;


public class RetrofitForgetPwdAuthCodeHttpUtils extends HttpUtils {

    private ForgetPwdAuthCodeService forgetPwdAuthCodeService;

    public RetrofitForgetPwdAuthCodeHttpUtils(ForgetPwdAuthCodeService forgetPwdAuthCodeService) {
        this.forgetPwdAuthCodeService = forgetPwdAuthCodeService;
    }

    public Observable<BaseResponse<AuthCodeBean>> fetchgetForgetPwdAuthCode(AuthCode forgetPwdAuthCode) {
       return forgetPwdAuthCodeService.getForgetPwdAuthCode(forgetPwdAuthCode);
    }

    public Observable<BaseResponse<CheckAuthCodeBean>> getCheckAuthCode(CheckAuthCode checkAuthCode) {
        return forgetPwdAuthCodeService.getCheckAuthCode(checkAuthCode);
    }
}
