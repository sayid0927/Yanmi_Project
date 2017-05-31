package com.aliter.injector.component;

import com.aliter.http.service.LoginService;
import com.aliter.http.utils.RetrofitLoginHttpUtils;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginHttpModule_ProvideRetrofitLoginUtilsFactory implements Factory<RetrofitLoginHttpUtils> {
  private final LoginHttpModule module;
  private final Provider<LoginService> weChatServiceProvider;

  public LoginHttpModule_ProvideRetrofitLoginUtilsFactory(LoginHttpModule module, Provider<LoginService> weChatServiceProvider) {  
    assert module != null;
    this.module = module;
    assert weChatServiceProvider != null;
    this.weChatServiceProvider = weChatServiceProvider;
  }

  @Override
  public RetrofitLoginHttpUtils get() {  
    RetrofitLoginHttpUtils provided = module.provideRetrofitLoginUtils(weChatServiceProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<RetrofitLoginHttpUtils> create(LoginHttpModule module, Provider<LoginService> weChatServiceProvider) {  
    return new LoginHttpModule_ProvideRetrofitLoginUtilsFactory(module, weChatServiceProvider);
  }
}

