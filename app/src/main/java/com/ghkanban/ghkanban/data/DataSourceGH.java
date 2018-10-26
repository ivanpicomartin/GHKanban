package com.ghkanban.ghkanban.data;

import android.support.annotation.NonNull;

import java.util.List;

public interface DataSourceGH {


    void getRepository(@NonNull String taskId);

    void getRepositories();
}
