package com.example.cartoon.passwordmanager;

/**
 * Created by cartoon on 2018/1/27.
 */

public interface ValueCallBack<T>{
    void onSuccess(T t);
    void onFail(String code);
}
