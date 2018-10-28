package com.ghkanban.ghkanban.mainboard;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.ghkanban.ghkanban.data.ListRepository;
import com.ghkanban.ghkanban.data.RepositoryObject;
import com.ghkanban.ghkanban.data.network.GHRetrofit;
import com.ghkanban.ghkanban.data.network.RepositoryManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//scoped
public class MainBoardPresenter  implements MainBoardContract.Presenter{

    private static MainBoardPresenter mainBoardPresenter;
    private MainBoardContract.View mainBoardView;

    //inject
    public MainBoardPresenter(){
    }

    @Override
    public void addRepository() {
        // save to local store
        // no store if already in local store
    }

    @Override
    public void removeRepository() {
        // remove from local store
        // if empty show empty local repository view

    }

    @Override
    public void openRepositoryIssues(@NonNull RepositoryObject repositoryObject) {
        //user's selected a local repository
        // show issues
    }

    @Override
    public void changeToLocalRepositories() {
        // start view loading
        mainBoardView.showLoadingIndicator(true);

        // get local repository data
        // if no local data get from server

        // stop view loading at the end

    }

    @Override
    public void changeToRemoteRepositories() {
        //start view loading
        mainBoardView.showLoadingIndicator(true);

        // load local data if exists
        // meanwhile load from github

        RepositoryManager repositoryManager = new RepositoryManager();

        repositoryManager.loadRemoteRepositories();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRemoteRepositoriesLoaded(ListRepository repositoryObjectList) {
        Log.d("LOAD REPOSITORIES","Repos " + repositoryObjectList);
        mainBoardView.showRemoteRepositories(repositoryObjectList);
    }

    @Override
    public void takeView(MainBoardContract.View view) {
        // view reference
        mainBoardView = view;
        EventBus.getDefault().register(this);
    }

    @Override
    public void dropView() {
        // remove view reference
        mainBoardView = null;
        EventBus.getDefault().unregister(this);

    }

}
