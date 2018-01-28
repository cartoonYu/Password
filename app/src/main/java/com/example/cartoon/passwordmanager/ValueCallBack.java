package com.example.cartoon.passwordmanager;

import com.example.cartoon.passwordmanager.data.Password;

import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public interface ValueCallBack{
    interface PasswordListCallBack<T>{
        void onSuccess(T t);
        void onFail(String code);
    }
}
