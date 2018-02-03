package com.example.cartoon.passwordmanager.data.TablePersonalInformation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cartoon on 2018/1/31.
 */

public class HandleInformationModel implements IPersonalInformation{
    private PersonalInformation information;        //presenter传入的数据
    private List<PersonalInformation> informations;
    private static int flag;       //用于判断后续操作
    private SQLiteDatabase db;
    public HandleInformationModel(){
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
        this.flag=0;
        this.informations=new ArrayList<>();
    }
    @Override
    public void setInformation(String password,String question,String answer){
        this.information=new PersonalInformation(password, question, answer);
    }
    @Override
    public void contrastInformation(final ValueCallBack.loginCallBack callBack){
        getList();
        if(informations.isEmpty()
                &&information.getQuestion().equals("")&&information.getAnswer().equals("")){
            flag=1;
        }
        else{
            if(!informations.isEmpty()
                    &&information.getQuestion().equals("")&&information.getAnswer().equals("")){
                for(PersonalInformation information1:informations){
                    if(information1.getPassword().equals(information.getPassword())){
                        flag=2;
                        callBack.onSuccess("登录成功");
                    }
                    else{
                        flag=3;
                        callBack.onFail("密码错误，请重试");
                    }
                }
            }
        }
        if((!information.getAnswer().equals("")||!information.getQuestion().equals(""))
                &&!information.getPassword().equals("")){
            ContentValues values=new ContentValues();
            values.put("password",information.getPassword());
            values.put("question",information.getQuestion());
            values.put("answer",information.getAnswer());
            db.insert("PersonalInformation",null,values);
            callBack.onSuccess("登录成功");
        }
    }
    @Override
    public int getState(){
        return flag;
    }
    @Override
    public void getList(){
        //遍历数据库
        Cursor cursor=db.query
                ("PersonalInformation",
                        null,null,null,
                        null,null,null);
        if(cursor.moveToFirst()){
            do{
                PersonalInformation information=new PersonalInformation(
                        cursor.getString(cursor.getColumnIndex("password")),
                        cursor.getColumnName(cursor.getColumnIndex("question")),
                        cursor.getColumnName(cursor.getColumnIndex("answer")));
                informations.add(information);
            }while(cursor.moveToNext());
            cursor.close();
        }
    }
    @Override
    public void revampInformation(){
        //修改information的值
    }
    @Override
    public void addInformation(final ValueCallBack.registerCallBack callBack){
        if(information.getPassword().equals("")&&information.getQuestion().equals("")&&information.getAnswer().equals("")){
            callBack.onFail("你所填写的信息不全");
        }
        else{
            callBack.onSuccess("注册成功");
        }
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                ContentValues values=new ContentValues();
                values.put("password",information.getPassword());
                values.put("question",information.getQuestion());
                values.put("answer",information.getAnswer());
                db.insert("PersonalInformation",null,values);
            }
        });
    }
}
