package com.example.cartoon.passwordmanager.Password.Main;

import com.example.cartoon.passwordmanager.data.TablePassword.Password;

import java.util.List;

/**
 * Created by cartoon on 2018/1/28.
 */

public interface IMainContract {
    interface Presenter {
        void initData();
        List<Password> getAdapterData();
    }
    interface View {
        void showToast(String code);
        void refreshAdapter();
        void onEmpty();
    }
}
