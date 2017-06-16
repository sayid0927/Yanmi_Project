package com.aliter.injector.component;


import com.aliter.http.service.ChangePwdService;
import com.aliter.http.utils.RetrofitShopSetPassword2HttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class AliteChangePwdModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideAuthCodeRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    ChangePwdService provideAuthCodeService(Retrofit retrofit) {
        return retrofit.create(ChangePwdService.class);
    }
    @Provides
    @Singleton
    RetrofitShopSetPassword2HttpUtils provideRetrofitAuthCodeUtils(ChangePwdService changePwdService) {
        return new RetrofitShopSetPassword2HttpUtils(changePwdService);
    }
}
