package com.example.cartoon.passwordmanager.data.TablePassword;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cartoon on 2018/2/17.
 */

class GetPassword implements IGetPassword{

    private SQLiteDatabase db;
    private ContentValues values;

    public GetPassword(){
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
        this.values=new ContentValues();
    }
    @Override
    public List<Password> getList(){
        List<Password> list=new ArrayList<>();
        Password password;
        Cursor cursor=db.query
                ("Password",
                        null,null,null,
                        null,null,null);
        if(cursor.moveToFirst()){
            do{
                password =new Password(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("account")),
                        cursor.getString(cursor.getColumnIndex("password")));
                list.add(password);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
    @Override
    public boolean addPassword(Password password){
        this.values.put("name",password.getName());
        this.values.put("account",password.getAccount());
        this.values.put("password",password.getPassword());
        this.db.insert("Password",null,values);
        return true;
    }
    @Override
    public boolean updatePassword(Password newPassword,Password oldPassword){
        this.values.put("name",newPassword.getName());
        this.values.put("account",newPassword.getAccount());
        this.values.put("password",newPassword.getPassword());
        this.db.update("Password",values,
                "name=? and account=? and password=?",
                new String[]{oldPassword.getName(),oldPassword.getAccount(),oldPassword.getPassword()});
        return true;
    }
    @Override
    public boolean deletePassword(Password password){
        db.delete("Password",
                "name=? and account=? and password=?",
                new String[]{password.getName(),password.getAccount(),password.getPassword()});
        return true;
    }
}
