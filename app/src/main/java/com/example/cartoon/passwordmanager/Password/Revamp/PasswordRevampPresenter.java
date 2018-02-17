package com.example.cartoon.passwordmanager.Password.Revamp;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePassword.HandlePassword;
import com.example.cartoon.passwordmanager.data.TablePassword.IHandlePassword;

/**
 * Created by cartoon on 2018/2/13.
 */

class PasswordRevampPresenter extends BasePresenter<PasswordRevamp> implements IPasswordRevamp.Presenter{
    private IPasswordRevamp.View view;
    private IHandlePassword model;
    private boolean flag;
    public PasswordRevampPresenter(IPasswordRevamp.View view) {
        this.view=view;
        this.model=new HandlePassword();
    }
    @Override
    public void initData(){
    }
    @Override
    public boolean getInput(){
        this.model.setPassword(view.getName(),view.getAccount(),view.getPassword(),
                view.getOldPassword());
        this.model.handleUpdatePassword(new ValueCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                view.showToast(s);
                flag=true;
            }

            @Override
            public void onFail(String code) {
                view.showToast(code);
                flag=false;
            }
        });
        return this.flag;
    }
}
