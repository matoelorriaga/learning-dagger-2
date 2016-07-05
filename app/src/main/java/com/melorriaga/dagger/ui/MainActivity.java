package com.melorriaga.dagger.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.melorriaga.dagger.DaggerApp;
import com.melorriaga.dagger.R;
import com.melorriaga.dagger.di.module.GitHubModule;
import com.melorriaga.dagger.domain.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject DaggerApp daggerApp;

    @Inject SharedPreferences sharedPreferences;

    @Inject Gson gson;

    @Inject Cache cache;

    @Inject @Named("cached") OkHttpClient cachedOkHttpClient;

    @Inject @Named("non_cached") OkHttpClient okHttpClient;

    @Inject Retrofit retrofit;

    @Inject GitHubModule.GitHubApiService gitHubApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDaggerApp().getGitHubComponent().inject(this);

        Log.i(TAG, "Injected: " + daggerApp);
        Log.i(TAG, "Injected: " + sharedPreferences);
        Log.i(TAG, "Injected: " + gson);
        Log.i(TAG, "Injected: " + cache);
        Log.i(TAG, "Injected: " + cachedOkHttpClient);
        Log.i(TAG, "Injected: " + okHttpClient);
        Log.i(TAG, "Injected: " + retrofit);
        Log.i(TAG, "Injected: " + gitHubApiService);

        gitHubApiService.getRepositories("matoelorriaga").enqueue(new Callback<List<Repository>>() {

            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                for (Repository repository: response.body()) {
                    Log.i(TAG, repository.getFullName());
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }

    public DaggerApp getDaggerApp() {
        return ((DaggerApp) getApplication());
    }

}
