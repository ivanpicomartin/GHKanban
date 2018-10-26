package com.ghkanban.ghkanban.issueboard;

import android.support.annotation.NonNull;

import com.ghkanban.ghkanban.BasePresenter;
import com.ghkanban.ghkanban.BaseView;
import com.ghkanban.ghkanban.data.IssueObject;

import java.util.List;

public interface IssueBoardContract {

    interface View extends BaseView<Presenter> {

        //show loading indicator
        void showLoadingIndicator(boolean active);

        void showIssues(List<IssueObject> issuesObjectList);

    }

    interface Presenter extends BasePresenter<View> {

        void moveIssueToNext(IssueObject issue);

        void moveIssueToPrevious(IssueObject issue);

        void changeToNextIssues();

        void changeToPreviousIssues();

    }
}
