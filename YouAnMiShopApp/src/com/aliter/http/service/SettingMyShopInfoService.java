package com.aliter.http.service;

import com.aliter.entity.ShopUpdate;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface SettingMyShopInfoService {



    @POST(AppController.shop_update)
    Observable<BaseResponse> ShopUpdate(@Body ShopUpdate shopUpdate);

}
