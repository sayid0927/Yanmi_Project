package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.PhoneRegisterService;

import rx.Observable;


public class RetrofitPhoneRegisterHttpUtils extends HttpUtils {

    private PhoneRegisterService phoneRegisterService;

    public RetrofitPhoneRegisterHttpUtils(PhoneRegisterService phoneRegisterService) {
        this.phoneRegisterService = phoneRegisterService;
    }

    public Observable<BaseResponse<AuthCodeBean>> fetchgetPhoneRegisterAuthCode(AuthCode authCode) {
       return phoneRegisterService.getPhoneRegisterAuthCode(authCode);
    }

}
