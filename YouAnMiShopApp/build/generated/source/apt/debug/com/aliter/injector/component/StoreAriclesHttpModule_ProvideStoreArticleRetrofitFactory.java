package com.aliter.injector.component;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class StoreAriclesHttpModule_ProvideStoreArticleRetrofitFactory implements Factory<Retrofit> {
  private final StoreAriclesHttpModule module;
  private final Provider<Builder> builderProvider;
  private final Provider<OkHttpClient> clientProvider;

  public StoreAriclesHttpModule_ProvideStoreArticleRetrofitFactory(StoreAriclesHttpModule module, Provider<Builder> builderProvider, Provider<OkHttpClient> clientProvider) {  
    assert module != null;
    this.module = module;
    assert builderProvider != null;
    this.builderProvider = builderProvider;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {  
    Retrofit provided = module.provideStoreArticleRetrofit(builderProvider.get(), clientProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Retrofit> create(StoreAriclesHttpModule module, Provider<Builder> builderProvider, Provider<OkHttpClient> clientProvider) {  
    return new StoreAriclesHttpModule_ProvideStoreArticleRetrofitFactory(module, builderProvider, clientProvider);
  }
}

