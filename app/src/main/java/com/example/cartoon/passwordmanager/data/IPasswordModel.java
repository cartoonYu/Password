package com.example.cartoon.passwordmanager.data;

import com.example.cartoon.passwordmanager.ValueCallBack;

import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public interface IPasswordModel {
    void getAdapterData(ValueCallBack<List<Password>> callBack);
    List<Password> getAdapterData();
}
