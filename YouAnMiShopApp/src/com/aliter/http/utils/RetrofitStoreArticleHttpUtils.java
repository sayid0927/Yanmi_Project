package com.aliter.http.utils;


import com.aliter.entity.StoreArticle;
import com.aliter.entity.StoreArticleBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.StoreArticleService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class RetrofitStoreArticleHttpUtils extends HttpUtils {

    private StoreArticleService storeArticleService;

    public RetrofitStoreArticleHttpUtils(StoreArticleService storeArticleService) {
        this.storeArticleService = storeArticleService;
    }

    public Observable<BaseResponse<StoreArticleBean>> fetchData(StoreArticle storeArticle) {
       return storeArticleService.getData(storeArticle);
    }
}
