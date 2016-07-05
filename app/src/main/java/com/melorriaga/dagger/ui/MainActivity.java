package com.melorriaga.dagger.ui;

import android.os.Bundle;
import android.util.Log;

import com.melorriaga.dagger.R;
import com.melorriaga.dagger.di.ParentDependency;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String DAGGER_VERSION = "dagger-version";

    @Inject
    ParentDependency parentDependency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAndroidComponent().inject(this);

        parentDependency.call();

        if (!sharedPreferences.contains(DAGGER_VERSION)) {
            sharedPreferences.edit().putInt(DAGGER_VERSION, 2).apply();
        }
        int daggerVersion = sharedPreferences.getInt(DAGGER_VERSION, 0);
        Log.i(TAG, String.valueOf(daggerVersion));
    }

}
