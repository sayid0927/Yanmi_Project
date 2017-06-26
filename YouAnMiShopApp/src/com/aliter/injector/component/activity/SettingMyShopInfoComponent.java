package com.aliter.injector.component.activity;


import com.aliter.injector.component.SettingMyShopInfoModule;
import com.aliter.ui.activity.myStore.AliteSettingShopNameActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { SettingMyShopInfoModule.class})
public interface SettingMyShopInfoComponent {

    void injectWeChat(AliteSettingShopNameActivity aliteSettingShopNameActivity);
}
