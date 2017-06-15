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

    public Observable<BaseResponse<CheckAuthCodeBean>> fetchCheckAuthCode(CheckAuthCode checkAuthCode) {
       return smsVerificationService.CheckAuthCode(checkAuthCode);
    }

    public Observable<BaseResponse<AuthCodeBean>> fetchgetAuthCode(AuthCode authCode) {
        return smsVerificationService.getAuthCode(authCode);
    }
}
