package com.aliter.presenter.impl;

import com.aliter.http.utils.RetrofitLoginHttpUtils;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginPresenterImpl_Factory implements Factory<LoginPresenterImpl> {
  private final MembersInjector<LoginPresenterImpl> membersInjector;
  private final Provider<RetrofitLoginHttpUtils> retrofitLoginHttpUtilsProvider;

  public LoginPresenterImpl_Factory(MembersInjector<LoginPresenterImpl> membersInjector, Provider<RetrofitLoginHttpUtils> retrofitLoginHttpUtilsProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert retrofitLoginHttpUtilsProvider != null;
    this.retrofitLoginHttpUtilsProvider = retrofitLoginHttpUtilsProvider;
  }

  @Override
  public LoginPresenterImpl get() {  
    LoginPresenterImpl instance = new LoginPresenterImpl(retrofitLoginHttpUtilsProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<LoginPresenterImpl> create(MembersInjector<LoginPresenterImpl> membersInjector, Provider<RetrofitLoginHttpUtils> retrofitLoginHttpUtilsProvider) {  
    return new LoginPresenterImpl_Factory(membersInjector, retrofitLoginHttpUtilsProvider);
  }
}

