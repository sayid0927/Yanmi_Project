package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.AuthCodeBean;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.CheckAuthCodeBean;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.WeixinUserPhoneService;

import rx.Observable;


public class RetrofitWeixinUserPhoneHttpUtils extends HttpUtils {

    private WeixinUserPhoneService weixinUserPhoneService;

    public RetrofitWeixinUserPhoneHttpUtils(WeixinUserPhoneService weixinUserPhoneService) {
        this.weixinUserPhoneService = weixinUserPhoneService;
    }


    public Observable<BaseResponse<AuthCodeBean>> getAuthCode(AuthCode authCode) {
        return weixinUserPhoneService.getAuthCode(authCode);
    }

    public Observable<BaseResponse<CheckAuthCodeBean>> getCheckAuthCode(CheckAuthCode checkAuthCode) {
        return weixinUserPhoneService.getCheckAuthCode(checkAuthCode);
    }

    public Observable<BaseResponse<MobileExistBean>> getisMobileExist(MobileExist mobileExist) {
        return weixinUserPhoneService.getisMobileExist(mobileExist);
    }
}
