package com.aliter.injector.component;


import com.aliter.http.service.HomeActivityService;
import com.aliter.http.utils.RetrofitHomeActivityHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
public class AliteHomeActivityModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideAuthCodeRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    HomeActivityService provideAuthCodeService(Retrofit retrofit) {
        return retrofit.create(HomeActivityService.class);
    }
    @Provides
    @Singleton
    RetrofitHomeActivityHttpUtils provideRetrofitAuthCodeUtils(HomeActivityService homeActivityService) {
        return new RetrofitHomeActivityHttpUtils(homeActivityService);
    }
}
