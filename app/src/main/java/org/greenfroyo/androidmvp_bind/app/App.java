package org.greenfroyo.androidmvp_bind.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.facebook.stetho.Stetho;

import org.greenfroyo.baseapp_mvp_bind.app.BaseApp;

/**
 * Created by fchristysen on 6/7/16.
 */

public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
    }

    //region init tools
    private void initStetho(){
        Stetho.initializeWithDefaults(this);
    }
    //endregion

}
