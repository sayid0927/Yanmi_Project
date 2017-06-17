package com.aliter.injector.component;


import com.aliter.http.service.LaunchActivityService;
import com.aliter.http.utils.RetrofitLaunchHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class LaunchHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideLonginRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    LaunchActivityService provideService(Retrofit retrofit) {
        return retrofit.create(LaunchActivityService.class);
    }
    @Provides
    @Singleton
    RetrofitLaunchHttpUtils provideRetrofitUtils(LaunchActivityService launchActivityService) {
        return new RetrofitLaunchHttpUtils(launchActivityService);
    }
}
