package com.aliter.http.service;


import com.aliter.entity.AuthCode;
import com.aliter.entity.CheckAuthCode;
import com.aliter.entity.Login;
import com.aliter.entity.MobileExist;
import com.aliter.entity.MobileExistBean;
import com.aliter.http.BaseResponse;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public interface WeixinUserPhoneService {

    @POST(AppController.shop_get_security_code)  //  获取验证码接口
    Observable <BaseResponse> ShopGetSecurityCode(@Body AuthCode authCode);


    @POST(AppController.shopAPP_check_security_code) //  验证验证码接口
    Observable <BaseResponse> ShopAPPCheckSecurityCode(@Body CheckAuthCode checkAuthCode);


    @POST(AppController.shopApp_isMobileExist)  //查询手机号是否注册1.0-非鉴权
    Observable <BaseResponse<MobileExistBean>> ShopAppisMobileExist (@Body MobileExist mobileExist);

    @POST(AppController.auth_shop_login2)       //微信老用户直接登录接口
    Observable <BaseResponse<IMUserInfoVO>> AuthShopLogin2(@Body Login login);




}
