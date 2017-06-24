package com.aliter.http.service;


import com.aliter.entity.ShopInfo;
import com.aliter.entity.ShopInfoBase;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface MyStoreService {

    @POST(AppController.shop_info)
    Observable <BaseResponse<ShopInfoBase>> ShopInfo(@Body ShopInfo shopInfo);


}
