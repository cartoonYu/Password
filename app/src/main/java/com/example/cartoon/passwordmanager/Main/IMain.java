package com.example.cartoon.passwordmanager.Main;

import com.example.cartoon.passwordmanager.data.Password;

import java.util.List;

/**
 * Created by cartoon on 2018/1/28.
 */

public interface IMain {
    interface Presenter {
        List<Password> getAdapterData();
    }
    interface View {
        void showToast(String code);
        void refreshAdapter();
        void onEmpty();
    }
}
