package com.aliter.http.utils;


import com.aliter.entity.Login;
import com.aliter.http.BaseResponse;
import com.aliter.http.HttpUtils;
import com.aliter.http.service.LaunchActivityService;
import com.easemob.easeui.model.IMUserInfoVO;

import rx.Observable;


public class RetrofitLaunchHttpUtils extends HttpUtils {

    private LaunchActivityService launchActivityService;

    public RetrofitLaunchHttpUtils(LaunchActivityService launchActivityService) {
        this.launchActivityService = launchActivityService;
    }

    public Observable<BaseResponse<IMUserInfoVO>> AuthShopLogin2(Login login) {
       return launchActivityService.AuthShopLogin2(login);
    }



}
