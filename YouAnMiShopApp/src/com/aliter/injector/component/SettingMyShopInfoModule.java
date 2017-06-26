package com.aliter.injector.component;


import com.aliter.http.service.SettingMyShopInfoService;
import com.aliter.http.utils.SettingMyShopInfoHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class SettingMyShopInfoModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideLonginRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    SettingMyShopInfoService provideService(Retrofit retrofit) {
        return retrofit.create(SettingMyShopInfoService.class);
    }
    @Provides
    @Singleton
    SettingMyShopInfoHttpUtils provideRetrofitLoginUtils(SettingMyShopInfoService settingMyShopInfoService) {
        return new SettingMyShopInfoHttpUtils(settingMyShopInfoService);
    }
}
