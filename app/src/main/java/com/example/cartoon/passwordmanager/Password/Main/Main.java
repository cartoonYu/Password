package com.example.cartoon.passwordmanager.Password.Main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.Password.AddPassword.AddPassword;
import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.PersonalInformation.RevampPassword.InformationRevampPassword;
import com.example.cartoon.passwordmanager.PersonalInformation.RevampQuestion.InformationRevampQuestion;
import com.example.cartoon.passwordmanager.util.Main.MainAdapter;
import com.example.cartoon.passwordmanager.util.PasswordManagerApplication;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by cartoon on 2018/1/27.
 */

public class Main extends BaseActivity<MainPresenter> implements IMainContract.View,View.OnClickListener{

    private TextView back;
    private TextView tag;

    private RecyclerView recyclerView;
    private ImageView menu;

    private FloatingActionButton addPassword;

    private DrawerLayout drawerLayout;
    private TextView revampQuestion;
    private TextView revampPassword;


    private MainAdapter adapter;
    private LinearLayoutManager manager;

    private Intent intent;

    @Override
    protected MainPresenter initPresent(){
        return new MainPresenter(this);
    }
    @Override
    protected int getLayout(){
        return R.layout.main;
    }
    @Override
    protected void initView(){
        drawerLayout=findViewById(R.id.mainDrawerLayout);
        tag=findViewById(R.id.toolbarTag);
        back=findViewById(R.id.toolbarBack);
        menu=findViewById(R.id.mainMenu);
        revampQuestion=findViewById(R.id.mainRevampQuestion);
        revampPassword=findViewById(R.id.mainRevampPassword);
        recyclerView=findViewById(R.id.mainPassword);
        addPassword=findViewById(R.id.mainAddPassword);
        back.setBackground(getResources().getDrawable(R.color.toolbar));
        tag.setText("密码管理器");
    }
    @Override
    protected void onPrepare(){
        initRecyclerView();
        menu.setOnClickListener(this);
        revampQuestion.setOnClickListener(this);
        revampPassword.setOnClickListener(this);
        addPassword.setOnClickListener(this);
    }
    @Override
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void refreshAdapter(){
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.mainMenu:{
                handleClickMenu();
                break;
            }
            case R.id.mainAddPassword:{
                handleClickAddPassword();
                break;
            }
            case R.id.mainRevampQuestion:{
                handleClickRevampQuestion();
                break;
            }
            case R.id.mainRevampPassword:{
                handleClickRevampPassword();
                break;
            }
        }
    }
    @Override
    public void handleClickMenu(){
        drawerLayout.openDrawer(GravityCompat.END);
    }
    @Override
    public void handleClickAddPassword(){
        intent=new Intent(this, AddPassword.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void handleClickRevampQuestion(){
        intent=new Intent(this, InformationRevampQuestion.class);
        intent.putExtra("flag",1);
        startActivity(intent);
        finish();
    }
    @Override
    public void handleClickRevampPassword(){
        intent=new Intent(this, InformationRevampPassword.class);
        intent.putExtra("flag",1);
        startActivity(intent);
        finish();
    }
    private void initRecyclerView() {
        adapter = new MainAdapter(this, basePresenter.getAdapterData());
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        basePresenter.initData();
    }
    @Override
    public void onBackPressed(){
        finish();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        RefWatcher watcher= PasswordManagerApplication.getRefWatcher(this);
        watcher.watch(this);
    }
}
