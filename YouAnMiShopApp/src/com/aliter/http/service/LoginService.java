package com.aliter.http.service;


import com.aliter.entity.Login;
import com.aliter.http.BaseResponse;
import com.easemob.easeui.model.IMUserInfoVO;
import com.zxly.o2o.application.AppController;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public interface LoginService {

    @POST(AppController.auth_shop_login2)
    Observable <BaseResponse<IMUserInfoVO>> getLogin(@Body Login login);
}
