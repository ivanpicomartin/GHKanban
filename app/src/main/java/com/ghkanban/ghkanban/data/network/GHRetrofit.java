package com.ghkanban.ghkanban.data.network;

import com.ghkanban.ghkanban.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//scoped
public class GHRetrofit  {

    private static GHRetrofit ghRetrofit;
    private Retrofit retrofit;
    private GHKanbanApi service;

    public static GHRetrofit getInstance() {
        if(ghRetrofit == null) {
            ghRetrofit = new GHRetrofit();
        }
        return ghRetrofit;
    }

    public void start() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(GHKanbanApi.class);
    }

    public GHKanbanApi getService() {
        return service;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
