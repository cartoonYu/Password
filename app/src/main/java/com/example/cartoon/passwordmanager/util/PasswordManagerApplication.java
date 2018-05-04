package com.example.cartoon.passwordmanager.util;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by cartoon on 2018/3/14.
 */

public class PasswordManagerApplication extends Application{
    private static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
