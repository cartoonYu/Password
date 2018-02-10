package com.example.cartoon.passwordmanager.login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Main.Main;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.Register.Register;
import com.example.cartoon.passwordmanager.RevampPassword.RevampPassword;
import com.example.cartoon.passwordmanager.data.MyDatabaseHelper;

/**
 * Created by cartoon on 2018/1/31.
 */

public class Login extends BaseActivity<LoginPresenter> implements ILoginContract.View, View.OnClickListener{
    private ImageView passwordForShow[];
    private Button inputPassword[];

    private static int flag;       //控制显示密码的数量

    @Override
    protected LoginPresenter initPresent(){
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
        passwordForShow[0]=(ImageView)findViewById(R.id.loginPassword1);
        passwordForShow[1]=(ImageView)findViewById(R.id.loginPassword2);
        passwordForShow[2]=(ImageView)findViewById(R.id.loginPassword3);
        passwordForShow[3]=(ImageView)findViewById(R.id.loginPassword4);
        passwordForShow[4]=(ImageView)findViewById(R.id.loginPassword5);
        passwordForShow[5]=(ImageView)findViewById(R.id.loginPassword6);
        inputPassword[0]=(Button)findViewById(R.id.loginInputPassword0);
        inputPassword[1]=(Button)findViewById(R.id.loginInputPassword1);
        inputPassword[2]=(Button)findViewById(R.id.loginInputPassword2);
        inputPassword[3]=(Button)findViewById(R.id.loginInputPassword3);
        inputPassword[4]=(Button)findViewById(R.id.loginInputPassword4);
        inputPassword[5]=(Button)findViewById(R.id.loginInputPassword5);
        inputPassword[6]=(Button)findViewById(R.id.loginInputPassword6);
        inputPassword[7]=(Button)findViewById(R.id.loginInputPassword7);
        inputPassword[8]=(Button)findViewById(R.id.loginInputPassword8);
        inputPassword[9]=(Button)findViewById(R.id.loginInputPassword9);
        inputPassword[10]=(Button)findViewById(R.id.loginInputPasswordForgetPassword);
        inputPassword[11]=(Button)findViewById(R.id.loginInputPasswordDeletePassword);
        MyDatabaseHelper helper=new MyDatabaseHelper(this,"PasswordManager.db",null,1);
        helper.getWritableDatabase();
    }
    @Override
    protected void onPrepare(){
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
    private void handleClick(String password){
        Intent intent;
        if(!password.equals("-2")){
            basePresenter.getDataFromView(password);
            flag=basePresenter.changeView();
            for(int i=0;i<6;i++){
                passwordForShow[i].setImageResource(0);
            }
            for(int i=0;i<flag;i++){
                passwordForShow[i].setImageResource(R.drawable.password);
            }
        }
        else{
            intent=new Intent(this, RevampPassword.class);
            intent.putExtra("flag",0);
            startActivity(intent);
            finish();
        }
        switch (basePresenter.intentView()){
            case 1:{
                intent=new Intent(this, Register.class);
                intent.putExtra("passwordFromLogin",basePresenter.returnPassword());
                startActivity(intent);
                finish();
                break;
            }
            case 2:{
                intent=new Intent(this, Main.class);
                startActivity(intent);
                finish();
                break;
            }
            case 3:{
                break;
            }
            default:{
                break;
            }
        }
    }
}
