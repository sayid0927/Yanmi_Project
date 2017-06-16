package com.aliter.http.service;


import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public interface WeixinUserPhoneService {



    @POST(AppController.shop_get_security_code)
    Observable <BaseResponse<AuthCodeBean>> getAuthCode(@Body AuthCode authCode);


    @POST(AppController.shopAPP_check_security_code) //  验证验证码接口
    Observable <BaseResponse<CheckAuthCodeBean>> getCheckAuthCode(@Body CheckAuthCode checkAuthCode);


    @POST(AppController.shopApp_isMobileExist)  //查询手机号是否注册1.0-非鉴权
    Observable <BaseResponse<MobileExistBean>> getisMobileExist (@Body MobileExist mobileExist);




}
