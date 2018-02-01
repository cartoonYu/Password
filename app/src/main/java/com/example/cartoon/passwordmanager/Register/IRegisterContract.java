package com.example.cartoon.passwordmanager.Register;

/**
 * Created by cartoon on 2018/2/1.
 */

public interface IRegisterContract {
    interface View{
        void showToast(String code);
    }
    interface Presenter{
        void addInformation();
        void setInformation(String password,String question,String answer);
    }
}
