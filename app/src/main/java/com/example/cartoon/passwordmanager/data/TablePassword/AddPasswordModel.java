package com.example.cartoon.passwordmanager.data.TablePassword;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.example.cartoon.passwordmanager.ValueCallBack;


/**
 * Created by cartoon on 2018/1/29.
 */

public class AddPasswordModel implements IPassword.addPasswordModel {
    private Password password;
    private SQLiteDatabase db;
    public AddPasswordModel(){
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
    }

    @Override
    public void setPassword(String name, String account, String password) {
        this.password =new Password(name,account,password);
    }

    @Override
    public void addPassword(ValueCallBack.addPasswordCallBack<Password> callBack){
        if((password.getName().equals(null))&&(password.getAccount().equals(null))&&(password.getPassword().equals(null))){
            callBack.onFail("新建失败，请重试");
        }
        else{
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    ContentValues values=new ContentValues();
                    values.put("name", password.getName());
                    values.put("account", password.getAccount());
                    values.put("password", password.getPassword());
                    db.insert("Password",null,values);
                }
            });
            callBack.onSuccess("新建成功");
        }
    }

}
