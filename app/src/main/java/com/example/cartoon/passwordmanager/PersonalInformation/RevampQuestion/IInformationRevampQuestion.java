package com.example.cartoon.passwordmanager.PersonalInformation.RevampQuestion;

/**
 * Created by cartoon on 2018/2/11.
 */

interface IInformationRevampQuestion {
    interface View{
        void showToast(String code);
        void intentToMain();
        String getInputQuestion();
        String getInputAnswer();
    }
    interface Presenter{
        void getInput();
    }
}
