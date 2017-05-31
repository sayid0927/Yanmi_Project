package com.aliter.injector.component;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BaseHttpModule_ProvideClientFactory implements Factory<OkHttpClient> {
  private final BaseHttpModule module;
  private final Provider<Builder> builderProvider;

  public BaseHttpModule_ProvideClientFactory(BaseHttpModule module, Provider<Builder> builderProvider) {  
    assert module != null;
    this.module = module;
    assert builderProvider != null;
    this.builderProvider = builderProvider;
  }

  @Override
  public OkHttpClient get() {  
    OkHttpClient provided = module.provideClient(builderProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OkHttpClient> create(BaseHttpModule module, Provider<Builder> builderProvider) {  
    return new BaseHttpModule_ProvideClientFactory(module, builderProvider);
  }
}

