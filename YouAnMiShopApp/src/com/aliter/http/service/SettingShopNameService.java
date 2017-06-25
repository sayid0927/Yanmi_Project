package com.aliter.http.service;

import com.aliter.http.BaseResponse;
import com.zxly.o2o.application.AppController;

import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;


public interface SettingShopNameService {


//    file	图片	string	图片数据流
//    isThum	是否要缩略图	number	Integer类型，1：不要，2：要，默认1
//    thumHeight	缩略图高度	number	Integer类型，范围：0<thumHeight<500
//    thumWidth	缩略图宽度	number	Integer类型，范围：0<thumHeight<500


    @Multipart
    @POST(AppController.common_image_upload)
    Observable<BaseResponse> CommonImageUpload(
                                               @Part MultipartBody.Part file);


}
