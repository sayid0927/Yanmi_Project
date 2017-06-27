package com.aliter.injector.component;

import com.aliter.http.MyGsonConverterFactory;
import com.zxly.o2o.application.AppController;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class BaseHttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.addInterceptor(new BaseInterceptor());
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }


    protected Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return builder
                .baseUrl(AppController.data_base_url)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//             .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(MyGsonConverterFactory.create())
                .build();
    }
}
