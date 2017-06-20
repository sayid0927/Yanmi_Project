package com.aliter.http.service;


import com.aliter.entity.ShopAppMenu;
import com.aliter.entity.ShopAppMenuBean;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface HomeActivityService {

    @POST(AppController.shopApp_menu)
    Observable <BaseResponse<List<ShopAppMenuBean>>> shopAppMenu(@Body ShopAppMenu shopAppMenu);


}
