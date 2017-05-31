package com.aliter.injector.component;


import com.aliter.http.service.StoreArticleService;
import com.aliter.http.utils.RetrofitStoreArticleHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class StoreAriclesHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideStoreArticleRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    StoreArticleService provideStoreArticleService(Retrofit retrofit) {
        return retrofit.create(StoreArticleService.class);
    }
    @Provides
    @Singleton
    RetrofitStoreArticleHttpUtils provideRetrofitStoreArticleUtils(StoreArticleService storeArticleService) {
        return new RetrofitStoreArticleHttpUtils(storeArticleService);
    }
}
