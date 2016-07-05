package com.melorriaga.dagger.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by melorriaga on 5/7/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
