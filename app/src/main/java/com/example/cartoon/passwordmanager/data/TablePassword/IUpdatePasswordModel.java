package com.example.cartoon.passwordmanager.data.TablePassword;

import com.example.cartoon.passwordmanager.ValueCallBack;

/**
 * Created by cartoon on 2018/2/13.
 */

public interface IUpdatePasswordModel {
    void setPassword(String name,String account,String password,Password oldPassword);
    void updatePassword(ValueCallBack<String> callBack);
}
