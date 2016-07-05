package com.melorriaga.dagger.di;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by melorriaga on 4/7/16.
 */
public class ChildDependency {

    private static final String TAG = ChildDependency.class.getSimpleName();

    @Inject // this means that this class now can be injected
    public ChildDependency() {}

    public void call() {
        Log.i(TAG, "call");
    }

}
