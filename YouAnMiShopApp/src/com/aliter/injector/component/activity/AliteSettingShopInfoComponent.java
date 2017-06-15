package com.aliter.injector.component.activity;


import com.aliter.injector.component.AliteSettingShopInfoHttpModule;
import com.aliter.ui.activity.login.AliteSettingShopInfoActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AliteSettingShopInfoHttpModule.class})
public interface AliteSettingShopInfoComponent {
    void injectData(AliteSettingShopInfoActivity aliteSettingShopInfoActivity);
}


