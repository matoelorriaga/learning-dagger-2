package com.melorriaga.dagger;

import android.app.Application;

import com.melorriaga.dagger.di.component.AndroidComponent;
import com.melorriaga.dagger.di.component.DaggerAndroidComponent;
import com.melorriaga.dagger.di.module.AndroidModule;

/**
 * Created by melorriaga on 4/7/16.
 */
public class DaggerApp extends Application {

    private AndroidComponent androidComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        androidComponent = DaggerAndroidComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
    }

    public AndroidComponent getAndroidComponent() {
        return androidComponent;
    }

}
