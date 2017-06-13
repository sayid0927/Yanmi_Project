package com.aliter.injector.component.activity;


import com.aliter.injector.component.AliteForgetPwdHttpModule;
import com.aliter.ui.activity.login.AliteForgetPwdActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AliteForgetPwdHttpModule.class})
public interface AliteForgetPwdComponent {
    void injectData(AliteForgetPwdActivity aliteForgetPwdActivity);
}


