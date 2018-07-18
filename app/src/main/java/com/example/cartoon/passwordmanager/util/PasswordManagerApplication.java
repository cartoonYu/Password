package com.example.cartoon.passwordmanager.util;

import android.app.Application;
import android.content.Context;


/**
 * Created by cartoon on 2018/3/14.
 */

public class PasswordManagerApplication extends Application{
    private static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
