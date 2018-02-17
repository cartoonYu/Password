package com.example.cartoon.passwordmanager.Password.Details;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Main.Main;
import com.example.cartoon.passwordmanager.Password.Revamp.PasswordRevamp;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.data.TablePassword.Password;

/**
 * Created by cartoon on 2018/2/11.
 */

public class PasswordDetails extends BaseActivity<PasswordDetailsPresenter>
        implements IPasswordDetails.View, View.OnClickListener{
    private TextView back;
    private TextView details;
    private TextView account;
    private TextView password;
    private TextView revamp;
    private TextView delete;

    private Intent intent;
    private Password passwordFromLast;

    private static boolean flag;

    @Override
    protected PasswordDetailsPresenter initPresent(){
        return new PasswordDetailsPresenter(this);
    }
    @Override
    protected int getLayout(){
        return R.layout.passworddetails;
    }
    @Override
    protected void initView(){
        back=(TextView)findViewById(R.id.toolbarBack);
        details=(TextView)findViewById(R.id.toolbarTag);
        account=(TextView)findViewById(R.id.passwordDetailsAccount);
        password=(TextView)findViewById(R.id.passwordDetailsPassword);
        revamp=(TextView)findViewById(R.id.passwordDetailsRevamp);
        delete=(TextView)findViewById(R.id.passwordDetailsDelete);
        passwordFromLast=(Password)getIntent().getSerializableExtra("data");
        details.setText(passwordFromLast.getName());
        account.setText(passwordFromLast.getAccount());
        password.setText(passwordFromLast.getPassword());
    }
    @Override
    protected void onPrepare(){
        back.setOnClickListener(this);
        revamp.setOnClickListener(this);
        delete.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.toolbarBack:{
                intent=new Intent(this,Main.class);
                intent.putExtra("dataFromDetails",passwordFromLast);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.passwordDetailsRevamp:{
                intent=new Intent(this,PasswordRevamp.class);
                intent.putExtra("dataFromDetails",passwordFromLast);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.passwordDetailsDelete:{
                final LayoutInflater inflater=LayoutInflater.from(this);
                final View view=inflater.inflate(R.layout.passworddetailsdelete,null);
                final TextView cancel=(TextView)view.findViewById(R.id.passwordDetailsDeleteCancel);
                final TextView confirm=(TextView)view.findViewById(R.id.passwordDetailsDeleteConfirm);
                final AlertDialog deletePassword=new AlertDialog.Builder(this).create();
                deletePassword.setView(view);
                deletePassword.setCancelable(true);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deletePassword.cancel();
                    }
                });
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        flag=basePresenter.handleDelete();
                        if(flag){
                            intent=new Intent(PasswordDetails.this,Main.class);
                            startActivity(intent);
                            finish();
                        }
                        deletePassword.cancel();
                    }
                });
                deletePassword.show();

                break;
            }
        }
    }
    @Override
    public void onBackPressed(){
        intent=new Intent(this,Main.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void showToast(String code){
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
    }
    @Override
    public Password getPassword(){
        return this.passwordFromLast;
    }
}
