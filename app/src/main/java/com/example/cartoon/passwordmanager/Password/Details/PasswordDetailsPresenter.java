package com.example.cartoon.passwordmanager.Password.Details;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePassword.HandlePassword;
import com.example.cartoon.passwordmanager.data.TablePassword.IHandlePassword;

/**
 * Created by cartoon on 2018/2/11.
 */

class PasswordDetailsPresenter extends BasePresenter<PasswordDetails> implements IPasswordDetails.Presenter{
    private IPasswordDetails.View view;
    private IHandlePassword model;
    private boolean flag;
    public PasswordDetailsPresenter(IPasswordDetails.View view){
        this.view=view;
        this.model=new HandlePassword();
    }
    @Override
    public void handleDelete(){
        model.setPassword(this.view.getPassword().getName(),
                this.view.getPassword().getAccount(),this.view.getPassword().getPassword());
        model.handleDeletePassword(new ValueCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                view.showToast(s);
                view.handleClickBack();
            }
            @Override
            public void onFail(String code) {
                view.showToast(code);
            }
        });
    }
}
