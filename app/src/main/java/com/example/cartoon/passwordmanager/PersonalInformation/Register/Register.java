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

    private TextView back;
    private TextView confirm;

    private EditText inputQuestion;
    private EditText inputAnswer;
    private EditText inputPassword;

    private String question;
    private String answer;
    private String password;

    private Intent intent;
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
        back=findViewById(R.id.toolbarBack);
        inputAnswer=findViewById(R.id.registerAnswer);
        inputQuestion=findViewById(R.id.registerQuestion);
        inputPassword=findViewById(R.id.registerPassword);
        confirm=findViewById(R.id.toolbarTool1);
        confirm.setText("确认");
    }
    @Override
    public void onPrepare(){
        intent=getIntent();
        passwordFromLogin=intent.getStringExtra("passwordFromLogin");
        question="";
        answer="";
        password="";
        back.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.toolbarBack:{
                handleClickBack();
                break;
            }
            case R.id.toolbarTool1:{
                handleClickSave();
                break;
            }
        }
    }
    @Override
    public void handleClickBack(){
        intent=new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void handleClickSave(){
        question=inputQuestion.getText().toString();
        answer=inputAnswer.getText().toString();
        password=inputPassword.getText().toString();
        basePresenter.getDataFromView(question,answer,password,passwordFromLogin);
        basePresenter.addInformation();
    }
    @Override
    public void intentToMain(){
        intent=new Intent(this,Main.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed(){
        handleClickBack();
    }
}
