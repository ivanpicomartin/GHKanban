package com.ghkanban.ghkanban.mainboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghkanban.ghkanban.R;
import com.ghkanban.ghkanban.data.ListRepository;
import com.ghkanban.ghkanban.data.RepositoryObject;

import java.util.List;

public class MainBoardFragment extends Fragment implements MainBoardContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_repos, container, false);

        return rootView;
    }

    @Override
    public void showLoadingIndicator(boolean active) {

    }

    @Override
    public void showLocalRepositories(List<RepositoryObject> repositoryObjectList) {

    }

    @Override
    public void showRemoteRepositories(ListRepository repositoryObjectList) {
        //add repositories to list adapter
    }

    @Override
    public void showNoRepositories() {

    }

    @Override
    public void showSuccessfulAdded() {

    }
}
