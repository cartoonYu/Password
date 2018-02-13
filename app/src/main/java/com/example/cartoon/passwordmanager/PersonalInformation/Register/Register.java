package com.example.cartoon.passwordmanager.PersonalInformation.Register;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Main.Main;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.PersonalInformation.login.Login;

/**
 * Created by cartoon on 2018/2/1.
 */

public class Register extends BaseActivity<RegisterPresenter> implements IRegisterContract.View, View.OnClickListener{
    private EditText inputQuestion;
    private EditText inputAnswer;
    private EditText inputPassword;
    private TextView confirm;

    private String question;
    private String answer;
    private String password;

    private String passwordFromLogin;    //从login传过来的密码，用于与再次输入的密码进行匹配
    @Override
    public void showToast(String code){
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
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
        inputAnswer=(EditText)findViewById(R.id.registerAnswer);
        inputQuestion=(EditText)findViewById(R.id.registerQuestion);
        inputPassword=(EditText)findViewById(R.id.registerPassword);
        confirm=(TextView)findViewById(R.id.registerConfirm);
    }
    @Override
    public void onPrepare(){
        Intent intent=getIntent();
        passwordFromLogin=intent.getStringExtra("passwordFromLogin");
        question="";
        answer="";
        password="";
        confirm.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.registerConfirm:{
                question=inputQuestion.getText().toString();
                answer=inputAnswer.getText().toString();
                password=inputPassword.getText().toString();
                basePresenter.getDataFromView(question,answer,password,passwordFromLogin);
                if(basePresenter.addInformation()==1){
                    Intent intent=new Intent(this,Main.class);
                    startActivity(intent);
                    finish();
                }
                break;
            }
        }
    }
    @Override
    public void onBackPressed(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
