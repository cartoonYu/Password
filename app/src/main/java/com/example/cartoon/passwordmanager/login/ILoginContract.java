package com.example.cartoon.passwordmanager.login;

/**
 * Created by cartoon on 2018/1/31.
 */

public interface ILoginContract {
    interface View{
        void showToast(String code);
    }
    interface Presenter{
        void contrastInformation();
        void getDataFromView(String password);
        int changeView();
        int intentView();
        String returnPassword();
    }
}
