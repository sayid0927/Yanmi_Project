package com.aliter.injector.component.activity;


import com.aliter.injector.component.LoginHttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { LoginHttpModule.class})
public interface LoginComponent {
}
