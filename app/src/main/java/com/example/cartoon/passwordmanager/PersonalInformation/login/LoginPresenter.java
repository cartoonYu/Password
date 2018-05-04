package com.example.cartoon.passwordmanager.PersonalInformation.login;


import android.util.Log;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.HandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.IHandleInformation;
import com.example.cartoon.passwordmanager.util.LogUtil;

/**
 * Created by cartoon on 2018/1/31.
 */

public class LoginPresenter extends BasePresenter<Login> implements ILoginContract.Presenter{

    private ILoginContract.View view;
    private IHandleInformation model;

    public LoginPresenter(ILoginContract.View view){
        this.view=view;
        this.model=new HandleInformation();
    }
    @Override
    public void contrastInformation(final String password){
        model.setInformation(password,"","");
        model.handleLogin(new ValueCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                view.showToast(s);
                view.intentToMain();
            }
            @Override
            public void onFail(String code) {
                view.showToast(code);
                view.intentToRegister(password);
            }
        });
    }
}
