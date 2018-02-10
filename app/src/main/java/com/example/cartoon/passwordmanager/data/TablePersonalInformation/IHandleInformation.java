package com.example.cartoon.passwordmanager.data.TablePersonalInformation;

import com.example.cartoon.passwordmanager.ValueCallBack;

import java.util.List;

/**
 * Created by cartoon on 2018/1/31.
 */

public interface IHandleInformation {
    void setInformation(String password,String question,String answer);
    void addInformation(ValueCallBack callBack);
    void getInformation(ValueCallBack<PersonalInformation> callBack);
    void handleLogin(ValueCallBack<String> callBack);
}
