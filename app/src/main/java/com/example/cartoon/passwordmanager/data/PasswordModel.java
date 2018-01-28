package com.example.cartoon.passwordmanager.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private SQLiteDatabase db;
    public PasswordModel(){
        this.listData=new ArrayList<>();
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
    }
    @Override
    public void getAdapterData(final ValueCallBack.PasswordListCallBack<List<Password>> callBack){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Password> passwords=new ArrayList<>();
                Cursor cursor=db.query
                        ("Password",
                                null,null,null,null,null,null);

                if(cursor.moveToFirst()){
                    do{
                        Password password=new Password(
                                cursor.getString(cursor.getColumnIndex("name")),
                                cursor.getString(cursor.getColumnIndex("account")),
                                cursor.getString(cursor.getColumnIndex("password")));
                        passwords.add(password);
                    }while (cursor.moveToNext());
                }
                cursor.close();
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
