package com.example.cartoon.passwordmanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cartoon on 2018/1/28.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_PASSWORD="create table Password("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"account text,"
            +"password text)";
    private static final String CREATE_PERSONALINFORMATION="create table PersonalInformation("
            +"id integer primary key autoincrement,"
            +"password text,"
            +"question text,"
            +"answer text)";
    private Context context;
    public MyDatabaseHelper
            (Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context, name, factory, version);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
                db.execSQL(CREATE_PASSWORD);
                db.execSQL(CREATE_PERSONALINFORMATION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB,int oldVersion,int newVersion){
    }
}
