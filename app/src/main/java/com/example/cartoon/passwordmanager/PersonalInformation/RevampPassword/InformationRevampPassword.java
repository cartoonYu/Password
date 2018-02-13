package com.example.cartoon.passwordmanager.PersonalInformation.RevampPassword;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Main.Main;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.PersonalInformation;
import com.example.cartoon.passwordmanager.PersonalInformation.login.Login;

/**
 * Created by cartoon on 2018/2/3.
 */

public class InformationRevampPassword extends BaseActivity<InformationRevampPasswordPresenter>
        implements IInformationRevampPasswordContract.View, View.OnClickListener{
    private TextView back;
    private TextView question;
    private EditText answer;
    private EditText password;
    private TextView confirm;


    private Intent intent;     //用于接收上一页面携带的数据
    private int flag;           //用于存储上一页面携带的数据

    @Override
    public InformationRevampPasswordPresenter initPresent(){
        return new InformationRevampPasswordPresenter(this);
    }
    @Override
    public int getLayout(){
        return R.layout.revamppassword;
    }
    @Override
    public void initView(){
        back=(TextView)findViewById(R.id.revampPasswordBack) ;
        question=(TextView) findViewById(R.id.revampPasswordQuestion);
        answer=(EditText)findViewById(R.id.revampPasswordAnswer);
        password=(EditText)findViewById(R.id.revampPasswordPassword);
        confirm=(TextView)findViewById(R.id.revampPasswordConfirm);
        basePresenter.initData();
    }
    @Override
    public void onPrepare(){
        intent=getIntent();
        flag=intent.getIntExtra("flag",0);
        back.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }
    @Override
    public void showToast(String code){
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.revampPasswordBack:{
                Intent intent;
                if(flag==0){
                    intent=new Intent(this, Login.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    if(flag==1){
                        intent=new Intent(this, Main.class);
                        startActivity(intent);
                        finish();
                    }
                }
                break;
            }
            case R.id.revampPasswordConfirm:{
                boolean flag=basePresenter.getInput();
                Intent intent;
                if(flag){
                    if(this.flag==0){
                        intent=new Intent(this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        if(this.flag==1){
                            intent=new Intent(this, Main.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
                break;
            }
        }
    }
    @Override
    public void onBackPressed(){
        Intent intent;
        if(flag==0){
            intent=new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }
        else{
            if(flag==1){
                intent=new Intent(this, Main.class);
                startActivity(intent);
                finish();
            }
        }
    }
    @Override
    public void initView(PersonalInformation information){
        this.question.setText(information.getQuestion());
    }
    @Override
    public String getAnswer(){
        return this.answer.getText().toString();
    }
    @Override
    public String getPassword(){
        return this.password.getText().toString();
    }
    @Override
    public String getQuestion(){
        return this.question.getText().toString();
    }
}
