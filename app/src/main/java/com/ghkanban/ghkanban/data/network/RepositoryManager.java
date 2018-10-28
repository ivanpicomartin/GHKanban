package com.ghkanban.ghkanban.data.network;

import com.ghkanban.ghkanban.data.ErrorObject;
import com.ghkanban.ghkanban.data.ListRepository;
import com.ghkanban.ghkanban.data.RepositoryObject;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RepositoryManager implements Callback<ListRepository> {

    public static GHKanbanApi getService() {


        return GHRetrofit.getInstance().getRetrofit().create(GHKanbanApi.class);

    }

    public void loadRemoteRepositories() {


        GHRetrofit ghRetrofit = GHRetrofit.getInstance();

        Call<ListRepository> call =
                RepositoryManager.getService().loadRepositories();

        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ListRepository> call, Response<ListRepository> response) {

        if (response.isSuccessful()) {
            ListRepository repositoryObjectList = response.body();
            EventBus.getDefault().post(repositoryObjectList);


        } else {
            System.out.println(response.errorBody());
            EventBus.getDefault().post(new ErrorObject());
        }
    }

    @Override
    public void onFailure(Call<ListRepository> call, Throwable t) {
        EventBus.getDefault().post(new ErrorObject());

    }


}
