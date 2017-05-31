package com.aliter.injector.component.fragment;


import com.aliter.injector.component.StoreAriclesHttpModule;
import com.aliter.ui.fragment.StoreArticlesFragmentAlite;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { StoreAriclesHttpModule.class})
public interface StoreArticlesComponent {
    void injectData(StoreArticlesFragmentAlite storeArticlesFragmentAlite);
}


