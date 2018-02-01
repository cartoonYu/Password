package com.example.cartoon.passwordmanager;

/**
 * Created by cartoon on 2018/1/27.
 */

public interface ValueCallBack{
    interface loginCallBack{
        void onSuccess(String code);
        void onFail(String code);
    }
    interface registerCallBack{
        void onSuccess(String code);
        void onFail(String code);
    }
    interface PasswordListCallBack<T>{
        void onSuccess(T t);
        void onFail(String code);
    }
    interface addPasswordCallBack<T>{
        void onSuccess(String code);
        void onFail(String code);
    }
}
