package com.example.cartoon.passwordmanager.data.TablePassword;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.cartoon.passwordmanager.ValueCallBack;

/**
 * Created by cartoon on 2018/2/13.
 */

public class UpdatePasswordModel implements IUpdatePasswordModel{
    private Password newPassword;
    private Password oldPassword;
    private SQLiteDatabase db;
    public UpdatePasswordModel(){
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
    }
    @Override
    public void setPassword(String name,String account,String password,Password oldPassword){
        this.newPassword=new Password(name,account,password);
        this.oldPassword=oldPassword;
    }
    @Override
    public void updatePassword(ValueCallBack<String> callBack){
        if(this.newPassword.getName().isEmpty()&&this.newPassword.getAccount().isEmpty()&&this.newPassword.getPassword().isEmpty()){
            callBack.onFail("你未输入任何信息");
        }
        else{
            ContentValues values=new ContentValues();
            values.put("name",newPassword.getName());
            values.put("account",newPassword.getAccount());
            values.put("password",newPassword.getPassword());
            db.update("Password",values,"name=? and account=? and password=?",new String[]{oldPassword.getName(),oldPassword.getAccount(),oldPassword.getPassword()});
            callBack.onSuccess("修改成功");
        }
    }
}
