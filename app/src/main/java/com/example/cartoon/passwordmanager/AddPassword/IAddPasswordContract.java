package com.example.cartoon.passwordmanager.AddPassword;

/**
 * Created by cartoon on 2018/1/29.
 */

public interface IAddPasswordContract {
    interface View{
        void showToast(String code);
        String getInputDecription();
        String getInputAccount();
        String getInputPassword();
    }
    interface Presenter{
        void addPassword();
        void savePassword(String name,String account,String password);
    }
}
