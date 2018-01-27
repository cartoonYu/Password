package com.example.cartoon.passwordmanager.data;

import com.example.cartoon.passwordmanager.ValueCallBack;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public class PasswordModel implements IPasswordModel{
    private List<Password> list;
    @Override
    public void getAdapterData(final ValueCallBack<List<Password>> callBack){
        list= DataSupport.findAll(Password.class);
        if(list.isEmpty()){
            callBack.onFail("没有数据存在");
        }
        else{
            callBack.onSuccess(list);
        }
    }
    @Override
    public List<Password> getAdapterData(){
        return list;
    }
}
