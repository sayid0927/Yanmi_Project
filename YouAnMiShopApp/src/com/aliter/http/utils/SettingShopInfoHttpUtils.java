package com.aliter.http.utils;


import com.aliter.entity.ShopRegister;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.SettingShopInfoService;
import com.easemob.easeui.model.IMUserInfoVO;

import rx.Observable;


public class SettingShopInfoHttpUtils extends HttpUtils {

    private SettingShopInfoService settingShopInfoService;

    public SettingShopInfoHttpUtils(SettingShopInfoService settingShopInfoService) {
        this.settingShopInfoService = settingShopInfoService;
    }

    public Observable<BaseResponse<IMUserInfoVO>> shopRegister(ShopRegister shopRegister) {
       return settingShopInfoService.AuthShopRegister(shopRegister);
    }

}
