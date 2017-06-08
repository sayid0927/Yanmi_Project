package com.aliter.http.service;


import com.aliter.entity.StoreArticle;
import com.aliter.entity.StoreArticleBean;
import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface StoreArticleService {

    @POST(AppController.keduoduo_promote_articles)
    Observable <BaseResponse<List<StoreArticleBean>>> getData(@Body StoreArticle storeArticle);
}
