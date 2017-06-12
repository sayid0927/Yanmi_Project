package com.aliter.injector.component;


import com.aliter.http.service.AuthCodeService;
import com.aliter.http.utils.RetrofitAuthCodeHttpUtils;

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
    AuthCodeService provideAuthCodeService(Retrofit retrofit) {
        return retrofit.create(AuthCodeService.class);
    }
    @Provides
    @Singleton
    RetrofitAuthCodeHttpUtils provideRetrofitAuthCodeUtils(AuthCodeService authCodeService) {
        return new RetrofitAuthCodeHttpUtils(authCodeService);
    }
}
