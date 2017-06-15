package com.aliter.http.service;


import com.aliter.entity.ShopRegister;
import com.aliter.http.BaseResponse;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface SettingShopInfoService {

    @POST(AppController.auth_shop_register)
    Observable <BaseResponse<IMUserInfoVO>> AuthShopRegister(@Body ShopRegister shopRegister);
}
