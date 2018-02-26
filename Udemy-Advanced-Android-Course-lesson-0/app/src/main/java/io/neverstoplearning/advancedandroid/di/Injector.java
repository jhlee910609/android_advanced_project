package io.neverstoplearning.advancedandroid.di;

import android.app.Activity;

/**
 * Created by junhee.lee on 2018. 2. 26..
 */

public class Injector {

    public Injector() {

    }

    public static void inject(Activity activity) {
        ActivityInjector.get(activity).inject(activity);
    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }
}
