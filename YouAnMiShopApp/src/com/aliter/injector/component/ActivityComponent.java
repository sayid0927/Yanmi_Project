package com.aliter.injector.component;

import android.app.Activity;

import com.aliter.injector.component.module.ActivityModule;
import com.aliter.injector.component.scope.ActivityScope;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
}
