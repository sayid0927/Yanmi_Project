package com.aliter.base;

import com.aliter.ui.SwipeBackActivity.SwipeBackActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BaseActivity_MembersInjector<P extends BasePresenter> implements MembersInjector<BaseActivity<P>> {
  private final MembersInjector<SwipeBackActivity> supertypeInjector;
  private final Provider<P> mPresenterProvider;

  public BaseActivity_MembersInjector(MembersInjector<SwipeBackActivity> supertypeInjector, Provider<P> mPresenterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  @Override
  public void injectMembers(BaseActivity<P> instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mPresenter = mPresenterProvider.get();
  }

  public static <P extends BasePresenter> MembersInjector<BaseActivity<P>> create(MembersInjector<SwipeBackActivity> supertypeInjector, Provider<P> mPresenterProvider) {  
      return new BaseActivity_MembersInjector<P>(supertypeInjector, mPresenterProvider);
  }
}

