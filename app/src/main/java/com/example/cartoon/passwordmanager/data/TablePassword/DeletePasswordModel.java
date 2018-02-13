package com.example.cartoon.passwordmanager.data.TablePassword;

import android.database.sqlite.SQLiteDatabase;

import com.example.cartoon.passwordmanager.ValueCallBack;

/**
 * Created by cartoon on 2018/2/13.
 */

public class DeletePasswordModel implements IDeletePassword{
    private Password password;
    private SQLiteDatabase db;
    public DeletePasswordModel(){
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
    }
    @Override
    public void setPassword(Password password){
        this.password=password;
    }
    @Override
    public void deletePassword(ValueCallBack<String> callBack){
        if(this.password.getName().isEmpty()&&this.password.getAccount().isEmpty()&&this.password.getPassword().isEmpty()){
            callBack.onFail("删除失败，请重试");
        }
        else{
            db.delete("Password",
                    "name=? and account=? and password=?",
                    new String[]{this.password.getName(),this.password.getAccount(),this.password.getPassword()});
            callBack.onSuccess("删除成功");
        }
    }
}
