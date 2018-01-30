package com.example.cartoon.passwordmanager.AddPassword;

import android.util.Log;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.AddPasswordModel;
import com.example.cartoon.passwordmanager.data.GetPasswordModel;
import com.example.cartoon.passwordmanager.data.IPasswordModel;
import com.example.cartoon.passwordmanager.data.Password;

/**
 * Created by cartoon on 2018/1/29.
 */

public class AddPasswordPresenter extends BasePresenter implements IAddPasswordContract.Presenter{
    private  IAddPasswordContract.View view;
    private IPasswordModel.addPasswordModel model;
    public AddPasswordPresenter(IAddPasswordContract.View view){
        this.view=view;
        this.model=new AddPasswordModel();

    }

    @Override
    public void savePassword(String name, String account, String password) {
        model.setPassword(name,account,password);
    }

    @Override
    public void initData() {
    }

    @Override
    public void addPassword() {
        savePassword(view.getInputDecription(),view.getInputAccount(),view.getInputPassword());
        Log.d("123",view.getInputDecription());
        model.addPassword(new ValueCallBack.addPasswordCallBack<Password>() {
            @Override
            public void onSuccess(String code) {
                   view.showToast(code);
            }

            @Override
            public void onFail(String code) {
                    view.showToast(code);
            }
        });
    }
}
