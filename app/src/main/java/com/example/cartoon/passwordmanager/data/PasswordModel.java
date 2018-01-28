package com.example.cartoon.passwordmanager.data;

import android.os.Handler;
import android.util.Log;

import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.IPasswordModel;
import com.example.cartoon.passwordmanager.data.Password;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public class PasswordModel implements IPasswordModel {
    private List<Password> listData;
    public PasswordModel(){
        this.listData=new ArrayList<>();
    }
    @Override
    public void getAdapterData(final ValueCallBack.PasswordListCallBack<List<Password>> callBack){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Password> passwords=new ArrayList<>();
                passwords.add(new Password("cartoon","12345","12345"));
                passwords.add(new Password("cartoon","12345","12345"));
                passwords.add(new Password("cartoon","12345","12345"));
                Log.d("asdf",""+passwords.size());
                if(passwords.isEmpty()){
                    callBack.onFail("没有数据存在");
                }
                else{
                    callBack.onSuccess(passwords);
                }
            }
        },1000);
    }
    @Override
    public List<Password> getAdapterData(){
        return listData;
    }
}
