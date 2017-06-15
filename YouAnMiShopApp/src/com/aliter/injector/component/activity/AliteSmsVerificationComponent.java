package com.aliter.injector.component.activity;


import com.aliter.injector.component.AliteSmsVerificationHttpModule;
import com.aliter.ui.activity.login.AliteSMSVerificationActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AliteSmsVerificationHttpModule.class})
public interface AliteSmsVerificationComponent {
    void injectData(AliteSMSVerificationActivity smsVerificationActivity);
}


