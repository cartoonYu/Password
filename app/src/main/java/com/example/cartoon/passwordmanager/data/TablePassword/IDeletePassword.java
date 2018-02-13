package com.example.cartoon.passwordmanager.data.TablePassword;

import com.example.cartoon.passwordmanager.ValueCallBack;

/**
 * Created by cartoon on 2018/2/13.
 */

public interface IDeletePassword {
    void setPassword(Password password);
    void deletePassword(ValueCallBack<String> valueCallBack);
}
