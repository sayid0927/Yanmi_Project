package com.aliter.injector.component;


import com.aliter.http.service.SettingShopInfoService;
import com.aliter.http.utils.SettingShopInfoHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class AliteSettingShopInfoHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideAuthCodeRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    SettingShopInfoService providSettingShopInfoService(Retrofit retrofit) {
        return retrofit.create(SettingShopInfoService.class);
    }
    @Provides
    @Singleton
    SettingShopInfoHttpUtils provideRetrofitSettingShopUtils(SettingShopInfoService settingShopInfoService) {
        return new SettingShopInfoHttpUtils(settingShopInfoService);
    }
}
