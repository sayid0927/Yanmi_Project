package com.aliter.injector.component.module.fragment;

import com.aliter.adapter.Test;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StoreArticlesModule {
    @Provides
    @Singleton
    public BaseQuickAdapter provideAdapter() {
        return new Test(new ArrayList());
    }
}
