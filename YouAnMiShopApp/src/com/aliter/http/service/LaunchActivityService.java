package com.aliter.http.service;


import com.aliter.entity.Login;
import com.aliter.http.BaseResponse;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface LaunchActivityService {


    @POST(AppController.auth_shop_login2)   // 登录接口
    Observable <BaseResponse<IMUserInfoVO>> AuthShopLogin2(@Body Login login);

}
