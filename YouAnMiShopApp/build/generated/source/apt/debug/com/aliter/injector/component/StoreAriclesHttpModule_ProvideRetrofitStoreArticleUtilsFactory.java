package com.aliter.injector.component;

import com.aliter.http.service.StoreArticleService;
import com.aliter.http.utils.RetrofitStoreArticleHttpUtils;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class StoreAriclesHttpModule_ProvideRetrofitStoreArticleUtilsFactory implements Factory<RetrofitStoreArticleHttpUtils> {
  private final StoreAriclesHttpModule module;
  private final Provider<StoreArticleService> storeArticleServiceProvider;

  public StoreAriclesHttpModule_ProvideRetrofitStoreArticleUtilsFactory(StoreAriclesHttpModule module, Provider<StoreArticleService> storeArticleServiceProvider) {  
    assert module != null;
    this.module = module;
    assert storeArticleServiceProvider != null;
    this.storeArticleServiceProvider = storeArticleServiceProvider;
  }

  @Override
  public RetrofitStoreArticleHttpUtils get() {  
    RetrofitStoreArticleHttpUtils provided = module.provideRetrofitStoreArticleUtils(storeArticleServiceProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<RetrofitStoreArticleHttpUtils> create(StoreAriclesHttpModule module, Provider<StoreArticleService> storeArticleServiceProvider) {  
    return new StoreAriclesHttpModule_ProvideRetrofitStoreArticleUtilsFactory(module, storeArticleServiceProvider);
  }
}

