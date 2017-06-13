package com.aliter.injector.component;


import com.aliter.http.service.ForgetPwdAuthCodeService;
import com.aliter.http.utils.RetrofitForgetPwdAuthCodeHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class AliteForgetPwdHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideAuthCodeRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    ForgetPwdAuthCodeService provideAuthCodeService(Retrofit retrofit) {
        return retrofit.create(ForgetPwdAuthCodeService.class);
    }
    @Provides
    @Singleton
    RetrofitForgetPwdAuthCodeHttpUtils provideRetrofitAuthCodeUtils(ForgetPwdAuthCodeService forgetPwdAuthCodeService) {
        return new RetrofitForgetPwdAuthCodeHttpUtils(forgetPwdAuthCodeService);
    }
}
