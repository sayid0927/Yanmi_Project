package com.aliter.http.utils;


import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.PhoneRegisterService;

import rx.Observable;


public class RetrofitPhoneRegisterHttpUtils extends HttpUtils {

    private PhoneRegisterService phoneRegisterService;

    public RetrofitPhoneRegisterHttpUtils(PhoneRegisterService phoneRegisterService) {
        this.phoneRegisterService = phoneRegisterService;
    }


    public Observable<BaseResponse<MobileExistBean>> ShopAppisMobileExist(MobileExist mobileExist) {
        return phoneRegisterService.ShopAppisMobileExist(mobileExist);
    }

}
