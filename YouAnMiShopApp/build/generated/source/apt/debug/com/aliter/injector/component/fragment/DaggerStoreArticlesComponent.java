package com.aliter.injector.component.fragment;

import com.aliter.base.BaseFragment;
import com.aliter.base.BaseFragment_MembersInjector;
import com.aliter.http.service.StoreArticleService;
import com.aliter.http.utils.RetrofitStoreArticleHttpUtils;
import com.aliter.injector.component.BaseHttpModule_ProvideClientFactory;
import com.aliter.injector.component.BaseHttpModule_ProvideOkHttpBuilderFactory;
import com.aliter.injector.component.BaseHttpModule_ProvideRetrofitBuilderFactory;
import com.aliter.injector.component.StoreAriclesHttpModule;
import com.aliter.injector.component.StoreAriclesHttpModule_ProvideRetrofitStoreArticleUtilsFactory;
import com.aliter.injector.component.StoreAriclesHttpModule_ProvideStoreArticleRetrofitFactory;
import com.aliter.injector.component.StoreAriclesHttpModule_ProvideStoreArticleServiceFactory;
import com.aliter.presenter.impl.StorArticlesPresenterImpl;
import com.aliter.presenter.impl.StorArticlesPresenterImpl_Factory;
import com.aliter.ui.fragment.StoreArticlesFragmentAlite;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerStoreArticlesComponent implements StoreArticlesComponent {
  private Provider<Retrofit.Builder> provideRetrofitBuilderProvider;
  private Provider<OkHttpClient.Builder> provideOkHttpBuilderProvider;
  private Provider<OkHttpClient> provideClientProvider;
  private Provider<Retrofit> provideStoreArticleRetrofitProvider;
  private Provider<StoreArticleService> provideStoreArticleServiceProvider;
  private Provider<RetrofitStoreArticleHttpUtils> provideRetrofitStoreArticleUtilsProvider;
  private Provider<StorArticlesPresenterImpl> storArticlesPresenterImplProvider;
  private MembersInjector<BaseFragment<StorArticlesPresenterImpl>> baseFragmentMembersInjector;
  private MembersInjector<StoreArticlesFragmentAlite> storeArticlesFragmentAliteMembersInjector;

  private DaggerStoreArticlesComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static StoreArticlesComponent create() {  
    return builder().build();
  }

  private void initialize(final Builder builder) {  
    this.provideRetrofitBuilderProvider = ScopedProvider.create(BaseHttpModule_ProvideRetrofitBuilderFactory.create(builder.storeAriclesHttpModule));
    this.provideOkHttpBuilderProvider = ScopedProvider.create(BaseHttpModule_ProvideOkHttpBuilderFactory.create(builder.storeAriclesHttpModule));
    this.provideClientProvider = ScopedProvider.create(BaseHttpModule_ProvideClientFactory.create(builder.storeAriclesHttpModule, provideOkHttpBuilderProvider));
    this.provideStoreArticleRetrofitProvider = ScopedProvider.create(StoreAriclesHttpModule_ProvideStoreArticleRetrofitFactory.create(builder.storeAriclesHttpModule, provideRetrofitBuilderProvider, provideClientProvider));
    this.provideStoreArticleServiceProvider = ScopedProvider.create(StoreAriclesHttpModule_ProvideStoreArticleServiceFactory.create(builder.storeAriclesHttpModule, provideStoreArticleRetrofitProvider));
    this.provideRetrofitStoreArticleUtilsProvider = ScopedProvider.create(StoreAriclesHttpModule_ProvideRetrofitStoreArticleUtilsFactory.create(builder.storeAriclesHttpModule, provideStoreArticleServiceProvider));
    this.storArticlesPresenterImplProvider = StorArticlesPresenterImpl_Factory.create((MembersInjector) MembersInjectors.noOp(), provideRetrofitStoreArticleUtilsProvider);
    this.baseFragmentMembersInjector = BaseFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), storArticlesPresenterImplProvider);
    this.storeArticlesFragmentAliteMembersInjector = MembersInjectors.delegatingTo(baseFragmentMembersInjector);
  }

  @Override
  public void injectData(StoreArticlesFragmentAlite storeArticlesFragmentAlite) {  
    storeArticlesFragmentAliteMembersInjector.injectMembers(storeArticlesFragmentAlite);
  }

  public static final class Builder {
    private StoreAriclesHttpModule storeAriclesHttpModule;
  
    private Builder() {  
    }
  
    public StoreArticlesComponent build() {  
      if (storeAriclesHttpModule == null) {
        this.storeAriclesHttpModule = new StoreAriclesHttpModule();
      }
      return new DaggerStoreArticlesComponent(this);
    }
  
    public Builder storeAriclesHttpModule(StoreAriclesHttpModule storeAriclesHttpModule) {  
      if (storeAriclesHttpModule == null) {
        throw new NullPointerException("storeAriclesHttpModule");
      }
      this.storeAriclesHttpModule = storeAriclesHttpModule;
      return this;
    }
  }
}

