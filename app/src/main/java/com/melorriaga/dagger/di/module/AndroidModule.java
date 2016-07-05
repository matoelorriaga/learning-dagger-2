package com.melorriaga.dagger.di.module;

import android.app.Activity;
import android.content.SharedPreferences;

import com.melorriaga.dagger.DaggerApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by melorriaga on 4/7/16.
 */
@Module
public class AndroidModule {

    private final DaggerApp app;

    public AndroidModule(DaggerApp app) {
        this.app = app;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return app.getSharedPreferences("dagger", Activity.MODE_PRIVATE);
    }

}
