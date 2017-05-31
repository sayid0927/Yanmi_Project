package com.aliter.injector.component;

import dagger.internal.Factory;
import javax.annotation.Generated;
import okhttp3.OkHttpClient.Builder;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BaseHttpModule_ProvideOkHttpBuilderFactory implements Factory<Builder> {
  private final BaseHttpModule module;

  public BaseHttpModule_ProvideOkHttpBuilderFactory(BaseHttpModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Builder get() {  
    Builder provided = module.provideOkHttpBuilder();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Builder> create(BaseHttpModule module) {  
    return new BaseHttpModule_ProvideOkHttpBuilderFactory(module);
  }
}

