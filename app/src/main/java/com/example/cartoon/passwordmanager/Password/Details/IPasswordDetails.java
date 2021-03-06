package com.example.cartoon.passwordmanager.Password.Details;

import com.example.cartoon.passwordmanager.data.TablePassword.Password;

/**
 * Created by cartoon on 2018/2/11.
 */

interface IPasswordDetails {
    interface View{
        void handleClickBack();
        void handleClickRevamp();
        void handleClickDelete();
        void showToast(String code);
        Password getPassword();
    }
    interface Presenter{
        void handleDelete();
    }
}
