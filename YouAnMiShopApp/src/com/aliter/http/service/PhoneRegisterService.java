package com.aliter.http.service;


import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface PhoneRegisterService {


    @POST(AppController.shopApp_isMobileExist)  //查询手机号是否注册1.0-非鉴权
    Observable <BaseResponse<MobileExistBean>> ShopAppisMobileExist (@Body MobileExist mobileExist);


}
