package com.melorriaga.dagger.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.melorriaga.dagger.DaggerApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by melorriaga on 4/7/16.
 */
@Module
public class AppModule {

    private DaggerApp app;

    public AppModule(DaggerApp app) {
        this.app = app;
    }

    // can be injected like this: @Inject DaggerApp daggerApp
    @Provides
    @Singleton
    DaggerApp provideDaggerApp() {
        return app;
    }

    // can be injected like this: @Inject SharedPreferences sharedPreferences
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(DaggerApp app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

}
