package com.example.cartoon.passwordmanager.Register;

import com.example.cartoon.passwordmanager.data.TablePersonalInformation.PersonalInformation;

/**
 * Created by cartoon on 2018/2/1.
 */

public interface IRegisterContract {
    interface View{
        void showToast(String code);
    }
    interface Presenter{
        int addInformation();
        void getDataFromView(String question,String answer,String password,String passwordForConfirm);
    }
}
