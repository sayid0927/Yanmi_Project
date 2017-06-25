package com.aliter.http.utils;


import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.SettingShopNameService;

import okhttp3.MultipartBody;
import rx.Observable;


public class SettingShopNameHttpUtils extends HttpUtils {

    private SettingShopNameService settingShopNameService;

    public SettingShopNameHttpUtils(SettingShopNameService settingShopNameService) {
        this.settingShopNameService = settingShopNameService;
    }

    public Observable<BaseResponse> CommonImageUpload( MultipartBody.Part file) {
       return settingShopNameService.CommonImageUpload(file);
    }

}
