package com.aliter.http.utils;


import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.Login;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.WeixinUserPhoneService;
import com.easemob.easeui.model.IMUserInfoVO;

import rx.Observable;


public class RetrofitWeixinUserPhoneHttpUtils extends HttpUtils {

    private WeixinUserPhoneService weixinUserPhoneService;

    public RetrofitWeixinUserPhoneHttpUtils(WeixinUserPhoneService weixinUserPhoneService) {
        this.weixinUserPhoneService = weixinUserPhoneService;
    }


    public Observable<BaseResponse> ShopGetSecurityCode(AuthCode authCode) {
        return weixinUserPhoneService.ShopGetSecurityCode(authCode);
    }

    public Observable<BaseResponse> ShopAPPCheckSecurityCode(CheckAuthCode checkAuthCode) {
        return weixinUserPhoneService.ShopAPPCheckSecurityCode(checkAuthCode);
    }

    public Observable<BaseResponse<MobileExistBean>> ShopAppisMobileExist(MobileExist mobileExist) {
        return weixinUserPhoneService.ShopAppisMobileExist(mobileExist);
    }
    public Observable<BaseResponse<IMUserInfoVO>> AuthShopLogin2(Login login) {
        return weixinUserPhoneService.AuthShopLogin2(login);
    }
}
