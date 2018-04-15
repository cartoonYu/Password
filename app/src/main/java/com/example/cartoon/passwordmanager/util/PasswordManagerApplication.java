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
    private RefWatcher refWatcher;
    @Override
    public void onCreate(){
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher=LeakCanary.install(this);
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
    public static RefWatcher getRefWatcher(Context context){
        PasswordManagerApplication application=(PasswordManagerApplication)context.getApplicationContext();
        return application.refWatcher;
    }
}
