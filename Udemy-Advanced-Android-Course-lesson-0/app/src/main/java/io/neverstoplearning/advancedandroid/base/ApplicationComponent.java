package io.neverstoplearning.advancedandroid.base;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JunHee on 2018. 2. 25..
 */
@Singleton
@Component(modules = ApplicaitonModule.class)
public interface ApplicationComponent {

    void inject(MyApplication myApplication);
}
