package com.example.cartoon.passwordmanager.Password.Main;

import com.example.cartoon.passwordmanager.data.TablePassword.Password;

import java.util.List;

/**
 * Created by cartoon on 2018/1/28.
 */

public interface IMainContract {
    interface View {
        void handleClickMenu();
        void handleClickAddPassword();
        void handleClickRevampQuestion();
        void handleClickRevampPassword();
        void showToast(String code);
        void refreshAdapter();
    }
    interface Presenter {
        void initData();
        List<Password> getAdapterData();
    }
}
