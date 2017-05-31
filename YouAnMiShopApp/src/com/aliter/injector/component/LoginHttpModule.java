package com.aliter.injector.component;


import com.aliter.http.service.LoginService;
import com.aliter.http.utils.RetrofitLoginHttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class LoginHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    Retrofit provideLonginRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client);
    }

    @Singleton
    @Provides
    LoginService provideLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }
    @Provides
    @Singleton
    RetrofitLoginHttpUtils provideRetrofitLoginUtils(LoginService weChatService) {
        return new RetrofitLoginHttpUtils(weChatService);
    }
}
