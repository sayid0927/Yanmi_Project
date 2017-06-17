package com.aliter.http.service;


import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface SmsVerificationService {

    @POST(AppController.shopAPP_check_security_code)    //  验证验证码接口
    Observable <BaseResponse> ShopAPPCheckSecurityCode(@Body CheckAuthCode checkAuthCode);

    @POST(AppController.shop_get_security_code)       //  获取验证码接口
    Observable <BaseResponse> ShopgetSecurityCode(@Body AuthCode authCode);

}
