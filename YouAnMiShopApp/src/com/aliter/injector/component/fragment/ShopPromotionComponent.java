package com.aliter.injector.component.fragment;


import com.aliter.injector.component.ShopPromotionModule;
import com.aliter.ui.fragment.homefragment.AliteShopPromotionFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ShopPromotionModule.class})
public interface ShopPromotionComponent {
    void injectData(AliteShopPromotionFragment aliteShopPromotionFragment);
}


