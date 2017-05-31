package com.aliter.injector.component;

import dagger.internal.Factory;
import javax.annotation.Generated;
import retrofit2.Retrofit.Builder;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BaseHttpModule_ProvideRetrofitBuilderFactory implements Factory<Builder> {
  private final BaseHttpModule module;

  public BaseHttpModule_ProvideRetrofitBuilderFactory(BaseHttpModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Builder get() {  
    Builder provided = module.provideRetrofitBuilder();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Builder> create(BaseHttpModule module) {  
    return new BaseHttpModule_ProvideRetrofitBuilderFactory(module);
  }
}

