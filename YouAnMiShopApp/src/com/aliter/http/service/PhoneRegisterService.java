package com.aliter.http.service;


import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface PhoneRegisterService {

    @POST(AppController.shop_get_security_code)
    Observable <BaseResponse<AuthCodeBean>> getPhoneRegisterAuthCode(@Body AuthCode authCode);


}
