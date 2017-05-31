package com.aliter.injector.component;

import com.aliter.http.service.LoginService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginHttpModule_ProvideLoginServiceFactory implements Factory<LoginService> {
  private final LoginHttpModule module;
  private final Provider<Retrofit> retrofitProvider;

  public LoginHttpModule_ProvideLoginServiceFactory(LoginHttpModule module, Provider<Retrofit> retrofitProvider) {  
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public LoginService get() {  
    LoginService provided = module.provideLoginService(retrofitProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<LoginService> create(LoginHttpModule module, Provider<Retrofit> retrofitProvider) {  
    return new LoginHttpModule_ProvideLoginServiceFactory(module, retrofitProvider);
  }
}

