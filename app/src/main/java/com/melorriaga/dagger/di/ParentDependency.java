package com.melorriaga.dagger.di;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by melorriaga on 4/7/16.
 */
public class ParentDependency {

    private static final String TAG = ParentDependency.class.getSimpleName();

    private final ChildDependency childDependency;

    @Inject // this means that this class now can be injected
    public ParentDependency(ChildDependency childDependency) {
        this.childDependency = childDependency;
    }

    public void call() {
        Log.i(TAG, "call");
        if (childDependency != null) {
            childDependency.call();
        }
    }

}
