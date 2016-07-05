package com.melorriaga.dagger.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.melorriaga.dagger.DaggerApp;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by melorriaga on 4/7/16.
 */
@Module
public class NetworkModule {

    private String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // can be injected like this: @Inject Gson gson
    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    // can be injected like this: @Inject Cache cache
    @Provides
    @Singleton
    Cache provideCache(DaggerApp app) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(app.getCacheDir(), cacheSize);
    }

    // can be injected like this: @Inject @Named("cached") OkHttpClient okHttpClient
    @Provides
    @Singleton
    @Named("cached")
    OkHttpClient provideCachedOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    // can be injected like this: @Inject @Named("non_cached") OkHttpClient okHttpClient
    @Provides
    @Singleton
    @Named("non_cached")
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    // can be injected like this: @Inject Retrofit retrofit
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, @Named("cached") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

}
