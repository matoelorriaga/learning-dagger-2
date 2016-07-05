package com.melorriaga.dagger.di.component;

import com.melorriaga.dagger.di.module.AndroidModule;
import com.melorriaga.dagger.ui.BaseActivity;
import com.melorriaga.dagger.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by melorriaga on 4/7/16.
 */
@Singleton
@Component(modules = AndroidModule.class)
public interface AndroidComponent {

    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);

}
