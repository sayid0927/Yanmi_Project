package com.aliter.http.utils;


import com.aliter.entity.Statistics;
import com.aliter.entity.StatisticsBase;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.ShopPromotionService;

import rx.Observable;


public class ShopPromotionHttpUtils extends HttpUtils {

    private ShopPromotionService shopPromotionService;

    public ShopPromotionHttpUtils(ShopPromotionService shopPromotionService) {
        this.shopPromotionService = shopPromotionService;
    }


    public Observable<BaseResponse<StatisticsBase>> aitrleHomepageStatistics(Statistics statistics) {
        return shopPromotionService.aitrleHomepageStatistics(statistics);
    }

}
