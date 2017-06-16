package com.aliter.http.utils;


import com.aliter.entity.ShopSetPassword2;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.ChangePwdService;

import rx.Observable;


public class RetrofitShopSetPassword2HttpUtils extends HttpUtils {

    private ChangePwdService changePwdService;

    public RetrofitShopSetPassword2HttpUtils(ChangePwdService changePwdService) {
        this.changePwdService = changePwdService;
    }
    public Observable<BaseResponse> ShopSetPassword2(ShopSetPassword2 shopSetPassword2) {
       return changePwdService.ShopSetPassword2(shopSetPassword2);
    }
}
