package com.melorriaga.dagger.di.component;

import com.melorriaga.dagger.di.module.GitHubModule;
import com.melorriaga.dagger.di.scope.CustomScope;
import com.melorriaga.dagger.ui.MainActivity;

import dagger.Component;

/**
 * Created by melorriaga on 5/7/16.
 */
@CustomScope
@Component(
        dependencies = AppComponent.class,
        modules = GitHubModule.class
)
public interface GitHubComponent {

    void inject(MainActivity mainActivity);

}
