package io.neverstoplearning.advancedandroid.base;

import android.app.Application;

import javax.inject.Inject;

import io.neverstoplearning.advancedandroid.di.ActivityInjector;

/**
 * Created by JunHee on 2018. 2. 25..
 */

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicaitonModule(new ApplicaitonModule(this))
                .build();

        component.inject(this);

    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
