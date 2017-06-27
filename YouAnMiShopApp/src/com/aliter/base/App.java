package com.aliter.base;

import com.zxly.o2o.application.AppController;


public class App extends AppController {


    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    private static App instance;
    public static AppComponent appComponent;

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .build();
        }
        return appComponent;
    }
}
