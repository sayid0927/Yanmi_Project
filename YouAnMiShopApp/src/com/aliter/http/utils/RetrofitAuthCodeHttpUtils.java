package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.AuthCodeService;

import rx.Observable;



public class RetrofitAuthCodeHttpUtils extends HttpUtils {

    private AuthCodeService authCodeService;

    public RetrofitAuthCodeHttpUtils(AuthCodeService authCodeService) {
        this.authCodeService = authCodeService;
    }

    public Observable<BaseResponse<AuthCodeBean>> fetchgetAuthCode(AuthCode authCode) {
       return authCodeService.getAuthCode(authCode);
    }
}
