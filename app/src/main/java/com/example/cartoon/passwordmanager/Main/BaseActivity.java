package com.example.cartoon.passwordmanager.Main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.cartoon.passwordmanager.Main.BasePresenter;
import com.example.cartoon.passwordmanager.data.MyDatabaseHelper;

/**
 * Created by cartoon on 2018/1/27.
 */

public abstract class BaseActivity<T extends BasePresenter> extends Activity{
    protected T basePresenter;
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(getLayout());
        initView();
        basePresenter=initPresent();
        onPrepare();
    }
    protected abstract T initPresent();
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void onPrepare();
}
