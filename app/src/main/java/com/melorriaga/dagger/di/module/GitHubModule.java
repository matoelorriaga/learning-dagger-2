package com.melorriaga.dagger.di.module;

import com.melorriaga.dagger.di.scope.CustomScope;
import com.melorriaga.dagger.domain.Repository;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by melorriaga on 4/7/16.
 */
@Module
public class GitHubModule {

    public interface GitHubApiService {

        @GET("/users/{user}/repos")
        Call<List<Repository>> getRepositories(@Path("user") String user);

    }

    // can be injected like this: @Inject GitHubModule.GitHubApiService gitHubApiService
    @Provides
    @CustomScope
    GitHubApiService provideGitHubApiService(Retrofit retrofit) {
        return retrofit.create(GitHubApiService.class);
    }

}
