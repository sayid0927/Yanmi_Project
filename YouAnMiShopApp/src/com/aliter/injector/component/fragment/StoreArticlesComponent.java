package com.aliter.injector.component.fragment;


import com.aliter.injector.component.StoreAriclesHttpModule;
import com.aliter.injector.component.module.fragment.StoreArticlesModule;
import com.aliter.ui.fragment.homefragment.AliteStoreArticlesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { StoreAriclesHttpModule.class, StoreArticlesModule.class})
public interface StoreArticlesComponent {
    void injectData(AliteStoreArticlesFragment aliteStoreArticlesFragment);
}


