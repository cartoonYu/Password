package com.example.cartoon.passwordmanager.data.TablePassword;

import com.example.cartoon.passwordmanager.ValueCallBack;

import java.util.List;

/**
 * Created by cartoon on 2018/2/17.
 */

public interface IHandlePassword {
    void setPassword(String name,String account,String password);
    void setPassword(String name,String account,String password,Password oldPassword);
    void handleMain(ValueCallBack<List<Password>> callBack);
    boolean handleAddPassword(ValueCallBack<String> callBack);
    boolean handleUpdatePassword(ValueCallBack<String> callBack);
    void handleDeletePassword(ValueCallBack<String> callBack);
}
