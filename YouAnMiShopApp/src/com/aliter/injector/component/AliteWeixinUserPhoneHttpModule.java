package com.aliter.injector.component;


import com.aliter.http.service.WeixinUserPhoneService;
import com.aliter.http.utils.RetrofitWeixinUserPhoneHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class AliteWeixinUserPhoneHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideAuthCodeRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    WeixinUserPhoneService provideService(Retrofit retrofit) {
        return retrofit.create(WeixinUserPhoneService.class);
    }
    @Provides
    @Singleton
    RetrofitWeixinUserPhoneHttpUtils provideRetrofitAuthCodeUtils(WeixinUserPhoneService weixinUserPhoneService) {
        return new RetrofitWeixinUserPhoneHttpUtils(weixinUserPhoneService);
    }
}
