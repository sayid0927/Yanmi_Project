package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.SmsVerificationService;

import rx.Observable;


public class SmsVerificationHttpUtils extends HttpUtils {

    private SmsVerificationService smsVerificationService;

    public SmsVerificationHttpUtils(SmsVerificationService smsVerificationService) {
        this.smsVerificationService = smsVerificationService;
    }

    public Observable<BaseResponse<CheckAuthCodeBean>> shopAPPCheckSecurityCode(CheckAuthCode checkAuthCode) {
       return smsVerificationService.ShopAPPCheckSecurityCode(checkAuthCode);
    }

    public Observable<BaseResponse<AuthCodeBean>> ShopgetSecurityCode(AuthCode authCode) {
        return smsVerificationService.ShopgetSecurityCode(authCode);
    }
}
