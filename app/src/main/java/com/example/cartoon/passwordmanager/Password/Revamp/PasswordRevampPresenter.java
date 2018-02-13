package com.example.cartoon.passwordmanager.Password.Revamp;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePassword.IUpdatePasswordModel;
import com.example.cartoon.passwordmanager.data.TablePassword.UpdatePasswordModel;

/**
 * Created by cartoon on 2018/2/13.
 */

class PasswordRevampPresenter extends BasePresenter<PasswordRevamp> implements IPasswordRevamp.Presenter{
    private IPasswordRevamp.View view;
    private IUpdatePasswordModel model;
    private boolean flag;
    public PasswordRevampPresenter(IPasswordRevamp.View view) {
        this.view=view;
        this.model=new UpdatePasswordModel();
    }
    @Override
    public void initData(){
    }
    @Override
    public boolean getInput(){
        model.setPassword(view.getName(),view.getAccount(),view.getPassword(),view.getOldPPassword());
        model.updatePassword(new ValueCallBack<String>() {
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
        return flag;
    }
}
