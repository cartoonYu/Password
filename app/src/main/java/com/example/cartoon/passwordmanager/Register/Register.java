package com.example.cartoon.passwordmanager.Register;

import android.content.Intent;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.login.Login;

/**
 * Created by cartoon on 2018/2/1.
 */

public class Register extends BaseActivity<RegisterPresenter> implements IRegisterContract.View{
    @Override
    public void showToast(String code){

    }
    @Override
    public RegisterPresenter initPresent(){
        return new RegisterPresenter(this);
    }
    @Override
    public int getLayout(){
        return R.layout.register;
    }
    @Override
    public void initView(){

    }
    @Override
    public void onPrepare(){

    }
    @Override
    public void onBackPressed(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
