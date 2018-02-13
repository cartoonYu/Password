package com.example.cartoon.passwordmanager.Password.Details;

import com.example.cartoon.passwordmanager.BasePresenter;

/**
 * Created by cartoon on 2018/2/11.
 */

class PasswordDetailsPresenter extends BasePresenter<PasswordDetails> implements IPasswordDetails.Presenter{
    private IPasswordDetails.View view;
    public PasswordDetailsPresenter(IPasswordDetails.View view){
        this.view=view;
    }
    @Override
    public void initData(){

    }
}
