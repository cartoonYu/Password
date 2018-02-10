package com.example.cartoon.passwordmanager.RevampPassword;

import com.example.cartoon.passwordmanager.data.TablePersonalInformation.PersonalInformation;

/**
 * Created by cartoon on 2018/2/3.
 */

public interface IRevampPasswordContract {
    interface View{
        void showToast(String code);
        void initView(PersonalInformation information);
    }
    interface Presenter{

    }
}
