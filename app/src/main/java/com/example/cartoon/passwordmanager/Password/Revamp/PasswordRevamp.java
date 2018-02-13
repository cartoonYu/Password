package com.example.cartoon.passwordmanager.Password.Revamp;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Details.PasswordDetails;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.data.TablePassword.Password;

/**
 * Created by cartoon on 2018/2/13.
 */

public class PasswordRevamp extends BaseActivity<PasswordRevampPresenter>
        implements IPasswordRevamp.View, View.OnClickListener{

    private TextView back;
    private TextView save;

    private EditText name;
    private EditText account;
    private EditText password;

    private Intent intent;
    private Password passwordFromDetails;
    @Override
    protected PasswordRevampPresenter initPresent(){
        return new PasswordRevampPresenter(this);
    }
    @Override
    protected int getLayout(){
        return R.layout.passworddetailsrevamp;
    }
    @Override
    protected void initView(){
        passwordFromDetails=(Password)getIntent().getSerializableExtra("dataFromDetails");
        back=(TextView)findViewById(R.id.toolbarBack);
        save=(TextView)findViewById(R.id.toolbarTool1);
        name=(EditText)findViewById(R.id.passwordRevampName);
        account=(EditText)findViewById(R.id.passwordRevampAccount);
        password=(EditText)findViewById(R.id.passwordRevampPassword);
        save.setText("保存");
        name.setText(passwordFromDetails.getName());
        account.setText(passwordFromDetails.getAccount());
        password.setText(passwordFromDetails.getPassword());
        name.setSelection(passwordFromDetails.getName().length());
    }
    @Override
    protected void onPrepare(){
        back.setOnClickListener(this);
        save.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.toolbarBack:{
                intent=new Intent(this, PasswordDetails.class);
                intent.putExtra("data",passwordFromDetails);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.toolbarTool1:{
                boolean flag=basePresenter.getInput();
                if(flag){
                    passwordFromDetails=new Password(getName(),getAccount(),getPassword());
                    intent=new Intent(this, PasswordDetails.class);
                    intent.putExtra("data",passwordFromDetails);
                    startActivity(intent);
                    finish();
                }
                break;
            }
        }
    }
    @Override
    public void showToast(String code){
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed(){
        intent=new Intent(this, PasswordDetails.class);
        intent.putExtra("data",passwordFromDetails);
        startActivity(intent);
        finish();
    }
    @Override
    public String getName(){
        return this.name.getText().toString();
    }
    @Override
    public String getAccount(){
        return this.account.getText().toString();
    }
    @Override
    public String getPassword(){
        return this.password.getText().toString();
    }
    @Override
    public Password getOldPPassword(){
        return passwordFromDetails;
    }
}
