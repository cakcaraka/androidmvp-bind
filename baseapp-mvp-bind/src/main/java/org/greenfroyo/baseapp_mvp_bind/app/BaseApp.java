package org.greenfroyo.baseapp_mvp_bind.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.facebook.stetho.Stetho;

/**
 * Created by fchristysen on 6/7/16.
 */

public class BaseApp extends Application {
    protected static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Resources resources(){
        return mContext.getResources();
    }

    public static Context context() {
        return mContext;
    }
}
