package com.aliter.base;


import com.aliter.http.BaseResponse;

/**
 * Created by quantan.liu on 2017/4/12.
 */

public interface BaseView<T> {
    void onSuccessView(BaseResponse<T> mData);//获取数据成功调用该方法。
    void onFailView(String errorMsg);//获取数据失败调用该方法。
}
