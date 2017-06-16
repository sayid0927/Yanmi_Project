package com.aliter.http.service;


import com.aliter.entity.ShopSetPassword2;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface ChangePwdService {

    @POST(AppController.shopApp_setpassword2)
    Observable <BaseResponse> ShopSetPassword2(@Body ShopSetPassword2 shopSetPassword2);


}
