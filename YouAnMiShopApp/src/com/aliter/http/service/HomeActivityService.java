package com.aliter.http.service;


import com.aliter.entity.ShopAppMenu;
import com.aliter.entity.ShopAppMenuBean;
import com.aliter.entity.Statistics;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface HomeActivityService {

    @POST(AppController.shopApp_menu)
    Observable <BaseResponse<ShopAppMenuBean>> shopAppMenu(@Body ShopAppMenu shopAppMenu);




}
