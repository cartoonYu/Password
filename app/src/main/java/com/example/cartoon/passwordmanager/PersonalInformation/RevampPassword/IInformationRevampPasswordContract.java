package com.example.cartoon.passwordmanager.PersonalInformation.RevampPassword;

import com.example.cartoon.passwordmanager.data.TablePersonalInformation.PersonalInformation;

/**
 * Created by cartoon on 2018/2/3.
 */

public interface IInformationRevampPasswordContract {
    interface View{
        void handleClickBack();
        void handleClickConfirm();
        void showToast(String code);
        void initView(PersonalInformation information);
        String getAnswer();
        String getPassword();
        String getQuestion();
    }
    interface Presenter{
        boolean getInput();
        void initData();
    }
}
