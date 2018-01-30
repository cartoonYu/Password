package com.example.cartoon.passwordmanager.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.cartoon.passwordmanager.ValueCallBack;

/**
 * Created by cartoon on 2018/1/29.
 */

public class AddPasswordModel implements IPasswordModel.addPasswordModel{
    private Password password;
    private SQLiteDatabase db;
    public AddPasswordModel(){
        //this.password=new Password(name,account,password);
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
    }

    @Override
    public void setPassword(String name, String account, String password) {
        this.password=new Password(name,account,password);
    }

    @Override
    public void addPassword(ValueCallBack.addPasswordCallBack<Password> callBack){
        ContentValues values=new ContentValues();
        values.put("name",password.getName());
        values.put("account",password.getAccount());
        values.put("password",password.getPassword());
        //db.insert("Password",null,values);
        if(db.insert("Password",null,values)==1){
            callBack.onSuccess("新建成功");
        }
        else{
            callBack.onFail("新建失败，请重试");
        }
    }

}
