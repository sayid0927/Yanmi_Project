package com.aliter.injector.component.activity;


import com.aliter.injector.component.AliteWeixinUserPhoneHttpModule;
import com.aliter.ui.activity.login.AliteWeixinUserPhoneActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AliteWeixinUserPhoneHttpModule.class})
public interface AliteWeixinUserPhoneComponent {
    void injectData(AliteWeixinUserPhoneActivity aliteWeixinUserPhoneActivity);
}


