package com.example.cartoon.passwordmanager.data.TablePersonalInformation;

import com.example.cartoon.passwordmanager.ValueCallBack;

/**
 * Created by cartoon on 2018/1/31.
 */

public interface IPersonalInformation {
    void setInformation(String password,String question,String answer);
    void contrastInformation(ValueCallBack.loginCallBack callBack);
    int getState();
}
