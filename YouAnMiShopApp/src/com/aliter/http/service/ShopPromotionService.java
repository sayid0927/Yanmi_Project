package com.aliter.http.service;

import com.aliter.entity.Statistics;
import com.aliter.entity.StatisticsBase;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface ShopPromotionService {



    @POST(AppController.aitrle_homepage_statistics)
    Observable <BaseResponse<StatisticsBase>> aitrleHomepageStatistics(@Body Statistics statistics);


}
