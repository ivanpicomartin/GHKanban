package com.ghkanban.ghkanban;

import android.app.Application;
import android.content.res.Configuration;

import com.ghkanban.ghkanban.data.network.GHRetrofit;

public class GHApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GHRetrofit.getInstance().start();

    }


}
