package com.example.cartoon.passwordmanager.data.TablePassword;

import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePassword.Password;

import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public interface IPassword {
    interface getPasswordModel{
        void getAdapterData(ValueCallBack.PasswordListCallBack<List<Password>> callBack);
        List<Password> getAdapterData();
    }
    interface addPasswordModel{
        void addPassword(ValueCallBack.addPasswordCallBack<Password> callBack);
        void setPassword(String name,String account,String password);
    }
}
