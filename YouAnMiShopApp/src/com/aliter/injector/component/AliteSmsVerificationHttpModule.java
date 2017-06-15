package com.aliter.injector.component;


import com.aliter.http.service.SmsVerificationService;
import com.aliter.http.utils.SmsVerificationHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class AliteSmsVerificationHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideAuthCodeRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    SmsVerificationService provideAuthCodeService(Retrofit retrofit) {
        return retrofit.create(SmsVerificationService.class);
    }
    @Provides
    @Singleton
    SmsVerificationHttpUtils provideRetrofitAuthCodeUtils(SmsVerificationService smsVerificationService) {
        return new SmsVerificationHttpUtils(smsVerificationService);
    }
}
