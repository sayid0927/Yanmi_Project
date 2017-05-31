package com.aliter.injector.component;

import com.aliter.http.service.StoreArticleService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class StoreAriclesHttpModule_ProvideStoreArticleServiceFactory implements Factory<StoreArticleService> {
  private final StoreAriclesHttpModule module;
  private final Provider<Retrofit> retrofitProvider;

  public StoreAriclesHttpModule_ProvideStoreArticleServiceFactory(StoreAriclesHttpModule module, Provider<Retrofit> retrofitProvider) {  
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public StoreArticleService get() {  
    StoreArticleService provided = module.provideStoreArticleService(retrofitProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<StoreArticleService> create(StoreAriclesHttpModule module, Provider<Retrofit> retrofitProvider) {  
    return new StoreAriclesHttpModule_ProvideStoreArticleServiceFactory(module, retrofitProvider);
  }
}

