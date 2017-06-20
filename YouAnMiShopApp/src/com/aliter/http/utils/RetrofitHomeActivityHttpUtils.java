package com.aliter.http.utils;


import com.aliter.entity.ShopAppMenu;
import com.aliter.entity.ShopAppMenuBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.HomeActivityService;

import java.util.List;

import rx.Observable;


public class RetrofitHomeActivityHttpUtils extends HttpUtils {

    private HomeActivityService homeActivityService;

    public RetrofitHomeActivityHttpUtils(HomeActivityService homeActivityService) {
        this.homeActivityService = homeActivityService;
    }

    public Observable<BaseResponse<List<ShopAppMenuBean>>> fetch(ShopAppMenu shopAppMenu) {
       return homeActivityService.shopAppMenu(shopAppMenu);
    }

}
