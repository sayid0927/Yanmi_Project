package com.aliter.injector.component;


import com.aliter.http.service.SettingShopNameService;
import com.aliter.http.utils.SettingShopNameHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class SettingShopNameHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    SettingShopNameService provideService(Retrofit retrofit) {
        return retrofit.create(SettingShopNameService.class);
    }
    @Provides
    @Singleton
    SettingShopNameHttpUtils provideRetrofitUtils(SettingShopNameService settingShopNameService) {
        return new SettingShopNameHttpUtils(settingShopNameService);
    }
}
