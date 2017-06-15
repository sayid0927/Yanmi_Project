package com.aliter.injector.component.activity;


import com.aliter.injector.component.AlitePhoneRegisterHttpModule;
import com.aliter.ui.activity.login.AlitePhoneRegisterActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AlitePhoneRegisterHttpModule.class})
public interface AlitePhoneRegisterComponent {
    void injectData(AlitePhoneRegisterActivity alitePhoneRegisterActivity);
}


