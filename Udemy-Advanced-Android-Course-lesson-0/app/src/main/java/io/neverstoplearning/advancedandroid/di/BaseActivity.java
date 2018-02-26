package io.neverstoplearning.advancedandroid.di;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by junhee.lee on 2018. 2. 26..
 */

public abstract class BaseActivity extends AppCompatActivity {

    private String instancdId;
    private static String INSTANCE_ID_KEY = "instance_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null){
            instancdId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instancdId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instancdId);
    }

    public String getInstancdId() {
        return instancdId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Injector.clearComponent(this);

        }

    }
}
