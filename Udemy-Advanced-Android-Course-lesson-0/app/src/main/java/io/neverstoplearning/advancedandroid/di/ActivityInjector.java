package io.neverstoplearning.advancedandroid.di;

import android.app.Activity;
import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;
import io.neverstoplearning.advancedandroid.base.MyApplication;

/**
 * Created by junhee.lee on 2018. 2. 26..
 */

public class ActivityInjector {

    private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity) {
        if(!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        String instanceId = ((BaseActivity) activity).getInstancdId();
        if (cache.containsKey(instanceId)){
            ((AndroidInjector<Activity>) cache.get(instanceId)).inject(activity);
            return;
        }

        AndroidInjector.Factory<Activity> injectorFactory =
                (AndroidInjector.Factory<Activity>) activityInjectors.get(activity.getClass()).get();
        AndroidInjector<Activity> injector = injectorFactory.create(activity);
        cache.put(instanceId, injector);
        injector.inject(activity);
    }

    void clear(Activity activity) {
        if(!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }
        cache.remove(((BaseActivity) activity).getInstancdId());
    }

    static ActivityInjector get(Context context) {
        return ((MyApplication) context.getApplicationContext()).getActivityInjector();
    }
}