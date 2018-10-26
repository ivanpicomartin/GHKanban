package com.ghkanban.ghkanban.mainboard;

import android.support.annotation.NonNull;

import com.ghkanban.ghkanban.BasePresenter;
import com.ghkanban.ghkanban.BaseView;
import com.ghkanban.ghkanban.data.RepositoryObject;

import java.util.List;

public interface MainBoardContract {


    interface View extends BaseView<Presenter> {

        //show loading indicator
        void showLoadingIndicator(boolean active);

        void showLocalRepositories(List<RepositoryObject> repositoryObjectList);

        void showRemoteRepositories(List<RepositoryObject> repositoryObjectList);

        void showNoRepositories();

        void showSuccessfulAdded();

    }

    interface Presenter extends BasePresenter<View> {

        void addRepository();

        void removeRepository();

        void openRepositoryIssues(@NonNull RepositoryObject repositoryObjectç);

        void changeToLocalRepositories();

        void changeToRemoteRepositories();

    }
}
