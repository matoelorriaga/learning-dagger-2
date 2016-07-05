package com.melorriaga.dagger.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.melorriaga.dagger.DaggerApp;
import com.melorriaga.dagger.di.component.AndroidComponent;

import javax.inject.Inject;

/**
 * Created by melorriaga on 4/7/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getAndroidComponent().inject(this);
    }

    public AndroidComponent getAndroidComponent() {
        return ((DaggerApp) getApplication()).getAndroidComponent();
    }

}
