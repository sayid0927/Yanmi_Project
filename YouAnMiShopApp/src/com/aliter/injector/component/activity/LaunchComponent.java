package com.aliter.injector.component.activity;


import com.aliter.injector.component.LaunchHttpModule;
import com.aliter.ui.activity.login.AliteLaunchActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { LaunchHttpModule.class})
public interface LaunchComponent {

    void injectWeChat(AliteLaunchActivity aliteLaunchActivity);
}
