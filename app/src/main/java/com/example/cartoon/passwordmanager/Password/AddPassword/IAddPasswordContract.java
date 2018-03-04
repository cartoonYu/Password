package com.example.cartoon.passwordmanager.Password.AddPassword;

/**
 * Created by cartoon on 2018/1/29.
 */

public interface IAddPasswordContract {
    interface View{
        void handleClickBack();
        void handleClickSave();
        void showToast(String code);
        String getInputDescription();
        String getInputAccount();
        String getInputPassword();
    }
    interface Presenter{
        void addPassword();
    }
}
