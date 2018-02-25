package io.neverstoplearning.advancedandroid.base;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by JunHee on 2018. 2. 25..
 */

public class MyApplication extends Application {

    @Inject
    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicaitonModule(new ApplicaitonModule(this))
                .build();

        component.inject(this);

    }
}
