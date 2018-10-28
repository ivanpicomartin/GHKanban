package com.ghkanban.ghkanban.data.network;

import com.ghkanban.ghkanban.data.ListRepository;
import com.ghkanban.ghkanban.data.RepositoryObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GHKanbanApi {

    @GET("/users/square/repos")
    Call<ListRepository> loadRepositories();
}
