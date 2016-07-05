package com.melorriaga.dagger;

import android.app.Application;

import com.melorriaga.dagger.di.component.AppComponent;
import com.melorriaga.dagger.di.component.DaggerAppComponent;
import com.melorriaga.dagger.di.component.DaggerGitHubComponent;
import com.melorriaga.dagger.di.component.GitHubComponent;
import com.melorriaga.dagger.di.module.AppModule;
import com.melorriaga.dagger.di.module.GitHubModule;
import com.melorriaga.dagger.di.module.NetworkModule;

/**
 * Created by melorriaga on 4/7/16.
 */
public class DaggerApp extends Application {

    private AppComponent appComponent;
    private GitHubComponent gitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://api.github.com"))
                .build();
        gitHubComponent = DaggerGitHubComponent.builder()
                .appComponent(appComponent)
                .gitHubModule(new GitHubModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public GitHubComponent getGitHubComponent() {
        return gitHubComponent;
    }

}
