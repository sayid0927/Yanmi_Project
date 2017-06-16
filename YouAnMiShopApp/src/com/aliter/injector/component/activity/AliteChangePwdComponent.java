package com.aliter.injector.component.activity;


import com.aliter.injector.component.AliteChangePwdModule;
import com.aliter.ui.activity.login.AliteChangePwdActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AliteChangePwdModule.class})
public interface AliteChangePwdComponent {
    void injectData(AliteChangePwdActivity aliteChangePwdActivity);
}


