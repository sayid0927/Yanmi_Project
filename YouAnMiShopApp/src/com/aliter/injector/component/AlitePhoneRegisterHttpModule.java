package com.aliter.injector.component;


import com.aliter.http.service.PhoneRegisterService;
import com.aliter.http.utils.RetrofitPhoneRegisterHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class AlitePhoneRegisterHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideAuthCodeRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    PhoneRegisterService provideAuthCodeService(Retrofit retrofit) {
        return retrofit.create(PhoneRegisterService.class);
    }
    @Provides
    @Singleton
    RetrofitPhoneRegisterHttpUtils provideRetrofitAuthCodeUtils(PhoneRegisterService phoneRegisterService) {
        return new RetrofitPhoneRegisterHttpUtils(phoneRegisterService);
    }
}
