package com.aliter.http.utils;


import com.aliter.entity.ShopUpdate;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.SettingMyShopInfoService;

import rx.Observable;


public class SettingMyShopInfoHttpUtils extends HttpUtils {

    private SettingMyShopInfoService settingMyShopInfoService;

    public SettingMyShopInfoHttpUtils(SettingMyShopInfoService settingMyShopInfoService) {
        this.settingMyShopInfoService = settingMyShopInfoService;
    }

    public Observable<BaseResponse> ShopUpdate(ShopUpdate shopUpdate) {
       return settingMyShopInfoService.ShopUpdate(shopUpdate);
    }

}
