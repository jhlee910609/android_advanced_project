package io.neverstoplearning.advancedandroid.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import io.neverstoplearning.advancedandroid.di.ActivityScope;

/**
 * Created by JunHee on 2018. 2. 25..
 */

@ActivityScope
@Subcomponent
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
