package com.example.cartoon.passwordmanager.Password.Main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.Password.AddPassword.AddPassword;
import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.PersonalInformation.RevampPassword.InformationRevampPassword;
import com.example.cartoon.passwordmanager.PersonalInformation.RevampQuestion.InformationRevampQuestion;
import com.example.cartoon.passwordmanager.util.Main.MainAdapter;

/**
 * Created by cartoon on 2018/1/27.
 */

public class Main extends BaseActivity<MainPresenter> implements IMainContract.View,View.OnClickListener{

    private TextView openDrawerLayout;
    private TextView tag;

    private RecyclerView recyclerView;

    private FloatingActionButton addPassword;

    private DrawerLayout drawerLayout;
    private TextView revampQuestion;
    private TextView revampPassword;


    private MainAdapter adapter;
    private LinearLayoutManager manager;

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
        drawerLayout=(DrawerLayout)findViewById(R.id.mainDrawerLayout);
        tag=(TextView)findViewById(R.id.toolbarTag);
        openDrawerLayout=(TextView)findViewById(R.id.toolbarBack);
        revampQuestion=(TextView)findViewById(R.id.mainRevampQuestion);
        revampPassword=(TextView)findViewById(R.id.mainRevampPassword);
        recyclerView=(RecyclerView)findViewById(R.id.mainPassword);
        addPassword=(FloatingActionButton)findViewById(R.id.mainAddPassword);
        openDrawerLayout.setBackground(getResources().getDrawable(R.drawable.ic_menu));
        tag.setText("密码管理器");
    }
    @Override
    protected void onPrepare(){
        initRecyclerView();
        openDrawerLayout.setOnClickListener(this);
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
    public void onEmpty(){
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.toolbarBack:{
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            }
            case R.id.mainAddPassword:{
                Intent intent=new Intent(this, AddPassword.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.mainRevampQuestion:{
                Intent intent=new Intent(this, InformationRevampQuestion.class);
                intent.putExtra("flag",1);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.mainRevampPassword:{
                Intent intent=new Intent(this, InformationRevampPassword.class);
                intent.putExtra("flag",1);
                startActivity(intent);
                finish();
                break;
            }
        }
    }
    private void initRecyclerView(){
        adapter=new MainAdapter(this,basePresenter.getAdapterData());
        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        basePresenter.initData();
    }
    @Override
    public void onBackPressed(){
        finish();
    }
}
