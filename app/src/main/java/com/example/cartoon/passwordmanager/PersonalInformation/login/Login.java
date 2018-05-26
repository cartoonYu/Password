package com.example.cartoon.passwordmanager.PersonalInformation.login;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Main.Main;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.PersonalInformation.Register.Register;
import com.example.cartoon.passwordmanager.PersonalInformation.RevampPassword.InformationRevampPassword;
import com.example.cartoon.passwordmanager.data.MyDatabaseHelper;
import com.example.cartoon.passwordmanager.util.PasswordManagerApplication;

/**
 * Created by cartoon on 2018/1/31.
 */

public class Login extends BaseActivity<LoginPresenter> implements ILoginContract.View, View.OnClickListener{

    private ImageView passwordForShow[];
    private Button inputPassword[];

    private int flag;           //控制输入的密码个数
    private StringBuilder password;    //最终用户输入的密码
    private Intent intent;

    private static final String TAG = "Activity2";

    @Override
    protected LoginPresenter initPresent(){
        MyDatabaseHelper helper=new MyDatabaseHelper(this,"PasswordManager.db",null,1);
        helper.getWritableDatabase();
        return new LoginPresenter(this);
    }
    @Override
    protected int getLayout(){
        return R.layout.login;
    }
    @Override
    protected void initView(){
        passwordForShow=new ImageView[6];
        inputPassword=new Button[12];
        passwordForShow[0]=findViewById(R.id.loginPassword1);
        passwordForShow[1]=findViewById(R.id.loginPassword2);
        passwordForShow[2]=findViewById(R.id.loginPassword3);
        passwordForShow[3]=findViewById(R.id.loginPassword4);
        passwordForShow[4]=findViewById(R.id.loginPassword5);
        passwordForShow[5]=findViewById(R.id.loginPassword6);
        inputPassword[0]=findViewById(R.id.loginInputPassword0);
        inputPassword[1]=findViewById(R.id.loginInputPassword1);
        inputPassword[2]=findViewById(R.id.loginInputPassword2);
        inputPassword[3]=findViewById(R.id.loginInputPassword3);
        inputPassword[4]=findViewById(R.id.loginInputPassword4);
        inputPassword[5]=findViewById(R.id.loginInputPassword5);
        inputPassword[6]=findViewById(R.id.loginInputPassword6);
        inputPassword[7]=findViewById(R.id.loginInputPassword7);
        inputPassword[8]=findViewById(R.id.loginInputPassword8);
        inputPassword[9]=findViewById(R.id.loginInputPassword9);
        inputPassword[10]=findViewById(R.id.loginInputPasswordForgetPassword);
        inputPassword[11]=findViewById(R.id.loginInputPasswordDeletePassword);
    }
    @Override
    protected void onPrepare(){
        flag=-1;
        password=new StringBuilder();
        for(int i=0;i<12;i++){
            inputPassword[i].setOnClickListener(this);
        }
    }
    @Override
    public void showToast(String code){
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.loginInputPassword0:{
                handleClick("0");
                break;
            }
            case R.id.loginInputPassword1:{
                handleClick("1");
                break;
            }
            case R.id.loginInputPassword2:{
                handleClick("2");
                break;
            }
            case R.id.loginInputPassword3:{
                handleClick("3");
                break;
            }
            case R.id.loginInputPassword4:{
                handleClick("4");
                break;
            }
            case R.id.loginInputPassword5:{
                handleClick("5");
                break;
            }
            case R.id.loginInputPassword6:{
                handleClick("6");
                break;
            }
            case R.id.loginInputPassword7:{
                handleClick("7");
                break;
            }
            case R.id.loginInputPassword8:{
                handleClick("8");
                break;
            }
            case R.id.loginInputPassword9:{
                handleClick("9");
                break;
            }
            case R.id.loginInputPasswordDeletePassword:{
                handleClick("-1");
                break;
            }
            case R.id.loginInputPasswordForgetPassword:{
                handleClick("-2");
                break;
            }
        }
    }
    @Override
    public void handleClick(String password){
        if(password.equals("-2")){
            intent=new Intent(this,InformationRevampPassword.class);
            startActivity(intent);
            finish();
        }
        else{
           if(password.equals("-1")){
               if(flag!=-1){
                   this.password.deleteCharAt(flag);
                   passwordForShow[flag--].setImageResource(0);
               }
           }
           else{
               this.password.append(password);
               passwordForShow[++flag].setImageResource(R.drawable.password);
           }
        }
        if(flag==5){
            basePresenter.contrastInformation(this.password.toString());
        }
    }
    @Override
    public void intentToMain(){
        intent=new Intent(this, Main.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void intentToRegister(String password){
        intent=new Intent(this, Register.class);
        intent.putExtra("passwordFromLogin",password);
        startActivity(intent);
        finish();
    }
}
