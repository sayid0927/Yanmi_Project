package com.aliter.injector.component;

import android.app.Activity;

import com.aliter.injector.component.module.FragmentModule;
import com.aliter.injector.component.scope.FragmentScope;

import dagger.Component;


@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

}
