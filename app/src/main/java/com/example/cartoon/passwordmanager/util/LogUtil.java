package com.example.cartoon.passwordmanager.util;

import android.util.Log;

/**
 * Created by cartoon on 2018/1/28.
 */

public class LogUtil {
    private static int verbose=1;
    private static int debug=2;
    private static int info=3;
    private static int warm=4;
    private static int error=5;
    private static int nothing=6;
    private static int level=verbose;
    public void v(String str1,String str2){
        if(level<=verbose){
            Log.v(str1,str2);
        }
    }
    public void d(String str1,String str2){
        if(level<=debug){
            Log.d(str1,str2);
        }
    }
    public void i(String str1,String str2){
        if(level<=info){
            Log.i(str1,str2);
        }
    }
    public void w(String str1,String str2){
        if(level<=warm){
            Log.w(str1,str2);
        }
    }
    public void e(String str1,String str2){
        if(level<=error){
            Log.e(str1,str2);
        }
    }
}
