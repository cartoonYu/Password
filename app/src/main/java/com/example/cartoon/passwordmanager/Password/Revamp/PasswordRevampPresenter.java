package com.example.cartoon.passwordmanager.Password.Revamp;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.BasePresenter;

/**
 * Created by cartoon on 2018/2/13.
 */

class PasswordRevampPresenter extends BasePresenter<PasswordRevamp> implements IPasswordRevamp.Presenter{
    private IPasswordRevamp.View view;
    public PasswordRevampPresenter(IPasswordRevamp.View view){
        this.view=view;
    }
    @Override
    public void initData(){

    }
}
