package com.aliter.injector.component;


import com.aliter.http.service.MyStoreService;
import com.aliter.http.utils.MyStroeHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class MyStroreHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    MyStoreService provideService(Retrofit retrofit) {
        return retrofit.create(MyStoreService.class);
    }
    @Provides
    @Singleton
    MyStroeHttpUtils provideRetrofitUtils(MyStoreService myStoreService) {
        return new MyStroeHttpUtils(myStoreService);
    }
}
