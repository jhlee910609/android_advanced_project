package io.neverstoplearning.advancedandroid.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JunHee on 2018. 2. 25..
 */
@Module
public class ApplicaitonModule {

    private final Application application;

    public ApplicaitonModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideApplicationcxt(){
        return application;
    }
}
