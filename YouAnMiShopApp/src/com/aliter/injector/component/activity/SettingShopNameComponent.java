package com.aliter.injector.component.activity;


import com.aliter.injector.component.SettingShopNameHttpModule;
import com.aliter.ui.activity.myStore.AliteSettingMyShopInfoActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { SettingShopNameHttpModule.class})
public interface SettingShopNameComponent {

    void injectWeChat(AliteSettingMyShopInfoActivity aliteSettingMyShopInfoActivity);
}
