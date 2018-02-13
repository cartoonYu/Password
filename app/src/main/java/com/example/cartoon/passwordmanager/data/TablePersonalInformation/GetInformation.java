package com.example.cartoon.passwordmanager.data.TablePersonalInformation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cartoon on 2018/2/10.
 */

public class GetInformation implements IGetInformation{

    private SQLiteDatabase db;
    private List<PersonalInformation> list;
    private PersonalInformation information;
    public GetInformation(){
        this.db= SQLiteDatabase.openOrCreateDatabase
                ("/data/data/com.example.cartoon.passwordmanager/databases/PasswordManager.db",null);
        this.list=new ArrayList<>();
    }
    @Override
    public boolean addInformation(final PersonalInformation information){
        if(information.getPassword().equals(null)&&
                information.getQuestion().equals(null)&&
                information.getAnswer().equals(null)){
            return false;
        }
        else{
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    ContentValues values=new ContentValues();
                    values.put("password", information.getPassword());
                    values.put("question", information.getQuestion());
                    values.put("answer", information.getAnswer());
                    db.insert("PersonalInformation",null,values);
                }
            });
            return true;
        }
    }
    @Override
    public List<PersonalInformation> getInformation(){
        Cursor cursor=db.query
                ("PersonalInformation",
                        null,null,null,
                        null,null,null);
        if(cursor.moveToFirst()){
            do{
                PersonalInformation information =new PersonalInformation(
                        cursor.getString(cursor.getColumnIndex("password")),
                        cursor.getString(cursor.getColumnIndex("question")),
                        cursor.getString(cursor.getColumnIndex("answer")));
                list.add(information);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
    @Override
    public boolean updateInformation(PersonalInformation information){
        if(information.getPassword().equals(null)&&
                information.getQuestion().equals(null)&&
                information.getAnswer().equals(null)){
            return false;
        }
        else{
            list=getInformation();
            this.information=new PersonalInformation
                    (list.get(0).getPassword(),list.get(0).getQuestion(),list.get(0).getAnswer());
            ContentValues values=new ContentValues();
            if(this.information.getQuestion().equals(information.getQuestion())){
                values.put("password",information.getPassword());

            }
            else{
                values.put("question",information.getQuestion());
                values.put("answer",information.getAnswer());
            }
            db.update("PersonalInformation",values,"password=?",new String[]{this.information.getPassword()});
            return true;
        }
    }
}
