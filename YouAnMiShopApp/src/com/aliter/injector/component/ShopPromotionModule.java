package com.aliter.injector.component;


import com.aliter.http.service.ShopPromotionService;
import com.aliter.http.utils.ShopPromotionHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class ShopPromotionModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideLonginRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    ShopPromotionService provideService(Retrofit retrofit) {
        return retrofit.create(ShopPromotionService.class);
    }
    @Provides
    @Singleton
    ShopPromotionHttpUtils provideRetrofitLoginUtils(ShopPromotionService shopPromotionService) {
        return new ShopPromotionHttpUtils(shopPromotionService);
    }
}
