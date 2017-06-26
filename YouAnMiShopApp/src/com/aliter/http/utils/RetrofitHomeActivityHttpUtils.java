package com.aliter.http.utils;


import com.aliter.entity.ShopAppMenu;
import com.aliter.entity.ShopAppMenuBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.HomeActivityService;

import rx.Observable;


public class RetrofitHomeActivityHttpUtils extends HttpUtils {

    private HomeActivityService homeActivityService;

    public RetrofitHomeActivityHttpUtils(HomeActivityService homeActivityService) {
        this.homeActivityService = homeActivityService;
    }

    public Observable<BaseResponse<ShopAppMenuBean>> fetch(ShopAppMenu shopAppMenu) {
       return homeActivityService.shopAppMenu(shopAppMenu);
    }

}
