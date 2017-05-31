package com.aliter.injector.component;

import com.blankj.utilcode.utils.PhoneUtils;
import com.blankj.utilcode.utils.StringUtils;
import com.zxly.o2o.util.PreferUtil;

import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/20.
 */

public class BaseInterceptor implements Interceptor {

    long serialNO = System.currentTimeMillis();
    String token = PreferUtil.getInstance().getLoginToken();
    public BaseInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();
        MediaType mediaType = originalRequest.body().contentType();
        Request.Builder requestBuilder;
        if(StringUtils.isEmpty(token)){
           requestBuilder = originalRequest.newBuilder()
                    .header("SerialNO", serialNO + "")
                    .header("DeviceID", PhoneUtils.getIMEI())
                    .header("DeviceType",  "1");
        }else {
            requestBuilder = originalRequest.newBuilder()
                    .header("Authorization", token)
                    .header("SerialNO", serialNO + "")
                    .header("DeviceID", PhoneUtils.getIMEI())
                    .header("DeviceType",  "1");
        }
        try {
            Field field = mediaType.getClass().getDeclaredField("mediaType");
            field.setAccessible(true);
            field.set(mediaType, "application/json; charset=UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = requestBuilder.build();
        Response originalResponse = chain.proceed(request);

        return originalResponse;
    }
}