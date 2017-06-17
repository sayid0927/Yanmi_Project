package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.SmsVerificationService;

import rx.Observable;


public class SmsVerificationHttpUtils extends HttpUtils {

    private SmsVerificationService smsVerificationService;

    public SmsVerificationHttpUtils(SmsVerificationService smsVerificationService) {
        this.smsVerificationService = smsVerificationService;
    }

    public Observable<BaseResponse> shopAPPCheckSecurityCode(CheckAuthCode checkAuthCode) {
       return smsVerificationService.ShopAPPCheckSecurityCode(checkAuthCode);
    }

    public Observable<BaseResponse> ShopgetSecurityCode(AuthCode authCode) {
        return smsVerificationService.ShopgetSecurityCode(authCode);
    }
}
