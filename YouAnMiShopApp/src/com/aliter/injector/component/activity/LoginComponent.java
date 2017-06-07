package com.aliter.injector.component.activity;


import com.aliter.injector.component.LoginHttpModule;
import com.aliter.ui.activity.login.AliteLoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { LoginHttpModule.class})
public interface LoginComponent {

    void injectWeChat(AliteLoginActivity aliteLoginActivity);
}
