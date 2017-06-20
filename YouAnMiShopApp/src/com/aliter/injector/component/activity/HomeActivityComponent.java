package com.aliter.injector.component.activity;


import com.aliter.injector.component.AliteHomeActivityModule;
import com.aliter.ui.activity.AliterHomeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AliteHomeActivityModule.class})
public interface HomeActivityComponent {

    void injectWeChat(AliterHomeActivity aliterHomeActivity);
}
