package com.aliter.http.utils;


import com.aliter.entity.ShopInfo;
import com.aliter.entity.ShopInfoBase;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.MyStoreService;

import rx.Observable;


public class MyStroeHttpUtils extends HttpUtils {

    private MyStoreService myStoreService;

    public MyStroeHttpUtils(MyStoreService myStoreService) {
        this.myStoreService = myStoreService;
    }

    public Observable<BaseResponse<ShopInfoBase>> ShopInfo(ShopInfo shopInfo) {
       return myStoreService.ShopInfo(shopInfo);
    }

}
