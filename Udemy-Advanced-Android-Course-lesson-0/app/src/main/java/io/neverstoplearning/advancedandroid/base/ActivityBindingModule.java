package io.neverstoplearning.advancedandroid.base;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import io.neverstoplearning.advancedandroid.home.MainActivity;
import io.neverstoplearning.advancedandroid.home.MainActivityComponent;

/**
 * Created by JunHee on 2018. 2. 25..
 */
@Module(subcomponents = MainActivityComponent.class)
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(MainActivityComponent.Builder builder);

}
