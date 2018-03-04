package com.example.cartoon.passwordmanager.PersonalInformation.login;


import android.util.Log;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.HandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.IHandleInformation;

/**
 * Created by cartoon on 2018/1/31.
 */

public class LoginPresenter extends BasePresenter<Login> implements ILoginContract.Presenter{

    private ILoginContract.View view;
    private IHandleInformation model;

    private String password;
    private static int flag;

    public LoginPresenter(ILoginContract.View view){
        this.view=view;
        this.model=new HandleInformation();
        this.password="";
        this.flag=0;
    }
    @Override
    public void contrastInformation(){
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
    @Override
    public void getDataFromView(String password){
        if(password.equals("-1")&&this.password.length()!=0){
            this.password=this.password.substring(0,this.password.length()-1);
        }
        else{
            if(password.equals("-1")&&this.password.length()==0){

            }
            else{
                this.password=this.password+password;
            }

        }
        flag=this.password.length();
        if(flag==6){
            flag=0;
            contrastInformation();
        }
    }
    @Override
    public int changeView(){
        return flag;
    }
}
