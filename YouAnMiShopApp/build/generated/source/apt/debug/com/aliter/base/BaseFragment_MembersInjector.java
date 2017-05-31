package com.aliter.base;

import android.support.v4.app.Fragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BaseFragment_MembersInjector<P extends BasePresenter> implements MembersInjector<BaseFragment<P>> {
  private final MembersInjector<Fragment> supertypeInjector;
  private final Provider<P> mPresenterProvider;

  public BaseFragment_MembersInjector(MembersInjector<Fragment> supertypeInjector, Provider<P> mPresenterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  @Override
  public void injectMembers(BaseFragment<P> instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mPresenter = mPresenterProvider.get();
  }

  public static <P extends BasePresenter> MembersInjector<BaseFragment<P>> create(MembersInjector<Fragment> supertypeInjector, Provider<P> mPresenterProvider) {  
      return new BaseFragment_MembersInjector<P>(supertypeInjector, mPresenterProvider);
  }
}

