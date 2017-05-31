package com.aliter.presenter.impl;

import com.aliter.http.utils.RetrofitStoreArticleHttpUtils;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class StorArticlesPresenterImpl_Factory implements Factory<StorArticlesPresenterImpl> {
  private final MembersInjector<StorArticlesPresenterImpl> membersInjector;
  private final Provider<RetrofitStoreArticleHttpUtils> retrofitStoreArticleHttpUtilsProvider;

  public StorArticlesPresenterImpl_Factory(MembersInjector<StorArticlesPresenterImpl> membersInjector, Provider<RetrofitStoreArticleHttpUtils> retrofitStoreArticleHttpUtilsProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert retrofitStoreArticleHttpUtilsProvider != null;
    this.retrofitStoreArticleHttpUtilsProvider = retrofitStoreArticleHttpUtilsProvider;
  }

  @Override
  public StorArticlesPresenterImpl get() {  
    StorArticlesPresenterImpl instance = new StorArticlesPresenterImpl(retrofitStoreArticleHttpUtilsProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<StorArticlesPresenterImpl> create(MembersInjector<StorArticlesPresenterImpl> membersInjector, Provider<RetrofitStoreArticleHttpUtils> retrofitStoreArticleHttpUtilsProvider) {  
    return new StorArticlesPresenterImpl_Factory(membersInjector, retrofitStoreArticleHttpUtilsProvider);
  }
}

