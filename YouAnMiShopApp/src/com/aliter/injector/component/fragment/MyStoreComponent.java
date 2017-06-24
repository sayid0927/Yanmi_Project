package com.aliter.injector.component.fragment;


import com.aliter.injector.component.MyStroreHttpModule;
import com.aliter.ui.fragment.MyStoreFragmentAlite;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { MyStroreHttpModule.class})
public interface MyStoreComponent {
    void injectData(MyStoreFragmentAlite myStoreFragmentAlite);
}


