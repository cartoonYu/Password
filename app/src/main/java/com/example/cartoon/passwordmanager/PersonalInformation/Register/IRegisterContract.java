package com.example.cartoon.passwordmanager.PersonalInformation.Register;

import com.example.cartoon.passwordmanager.data.TablePersonalInformation.PersonalInformation;

/**
 * Created by cartoon on 2018/2/1.
 */

public interface IRegisterContract {
    interface View{
        void handleClickBack();
        void handleClickSave();
        void intentToMain();
        void showToast(String code);
    }
    interface Presenter{
        void addInformation();
        void getDataFromView(String question,String answer,String password,String passwordForConfirm);
    }
}
