package com.example.cartoon.passwordmanager.PersonalInformation.login;

/**
 * Created by cartoon on 2018/1/31.
 */

public interface ILoginContract {
    interface View{
        void handleClick(String password);
        void showToast(String code);
        void intentToMain();
        void intentToRegister(String password);
    }
    interface Presenter{
        void contrastInformation(String password);
    }
}
