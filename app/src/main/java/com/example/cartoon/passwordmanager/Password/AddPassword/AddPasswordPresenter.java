package com.example.cartoon.passwordmanager.Password.AddPassword;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePassword.HandlePassword;
import com.example.cartoon.passwordmanager.data.TablePassword.IHandlePassword;

/**
 * Created by cartoon on 2018/1/29.
 */

public class AddPasswordPresenter extends BasePresenter implements IAddPasswordContract.Presenter{
    private IAddPasswordContract.View view;
    private IHandlePassword model;
    public AddPasswordPresenter(IAddPasswordContract.View view){
        this.view=view;
        this.model=new HandlePassword();
    }
    @Override
    public boolean addPassword() {
        model.setPassword(view.getInputDescription(),view.getInputAccount(),view.getInputPassword());
        boolean flag=model.handleAddPassword(new ValueCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                view.showToast(s);
            }

            @Override
            public void onFail(String code) {
                view.showToast(code);
            }
        });
        return flag;
    }
}
