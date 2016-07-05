package com.melorriaga.dagger.di.component;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.melorriaga.dagger.DaggerApp;
import com.melorriaga.dagger.di.module.AppModule;
import com.melorriaga.dagger.di.module.NetworkModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by melorriaga on 4/7/16.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent {

    // AppModule
    DaggerApp daggerApp();
    SharedPreferences sharedPreferences();

    // NetworkModule
    Gson gson();
    Cache cache();
    @Named("cached") OkHttpClient cachedOkHttpClient();
    @Named("non_cached") OkHttpClient okHttpClient();
    Retrofit retrofit();

}
