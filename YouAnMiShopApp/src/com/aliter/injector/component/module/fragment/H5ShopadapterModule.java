package com.aliter.injector.component.module.fragment;

import com.aliter.adapter.H5ShopListAdapter;
import com.aliter.entity.H5ShopBase;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class H5ShopadapterModule {
    @Provides
    @Singleton
    public BaseQuickAdapter provideAdapter() {
        return new H5ShopListAdapter(new ArrayList<H5ShopBase.ProductsBean>());
    }
}
