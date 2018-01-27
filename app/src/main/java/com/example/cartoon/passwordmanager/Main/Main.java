package com.example.cartoon.passwordmanager.Main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.R;

/**
 * Created by cartoon on 2018/1/27.
 */

public class Main extends BaseActivity<MainPresenter> implements IMainView{
    private RecyclerView recyclerView;
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
        recyclerView=(RecyclerView)findViewById(R.id.mainPassword);
    }
    @Override
    protected void onPrepare(){
        adapter=new MainAdapter(this,basePresenter.getAdapterData());
        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
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
}
