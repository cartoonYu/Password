package com.example.cartoon.passwordmanager.data.TablePassword;

import com.example.cartoon.passwordmanager.ValueCallBack;

import java.util.List;

/**
 * Created by cartoon on 2018/2/17.
 */

public class HandlePassword implements IHandlePassword{

    private GetPassword getPassword;
    private Password password;
    private Password oldPassword;

    private boolean flag;

    public HandlePassword(){
        this.getPassword=new GetPassword();
    }
    @Override
    public void setPassword(String name,String account,String password){
        this.password=new Password(name,account,password);
    }
    @Override
    public void setPassword(String name,String account,String password,Password oldPassword){
        this.password=new Password(name, account, password);
        this.oldPassword=oldPassword;
    }
    @Override
    public void handleMain(ValueCallBack<List<Password>> callBack){
        List<Password> list=this.getPassword.getList();
        if(list.isEmpty()){
            callBack.onFail("没有数据存在");
        }
        else{
            callBack.onSuccess(list);
        }
    }
    @Override
    public void handleAddPassword(ValueCallBack<String> callBack){
        if(this.password.getName().isEmpty()&&
                this.password.getAccount().isEmpty()&&
                this.password.getPassword().isEmpty()){
            callBack.onFail("你未输入任何信息，请重试");
            this.flag=false;
        }
        else{
            this.flag=this.getPassword.addPassword(this.password);
        }
        if(this.flag){
            callBack.onSuccess("新增成功");
        }
        else{
            callBack.onFail("新增失败，请重试");
        }
    }
    @Override
    public void handleUpdatePassword(ValueCallBack<String> callBack){
        if(this.password.getName().isEmpty()&&
                this.password.getAccount().isEmpty()&&
                this.password.getPassword().isEmpty()){
            callBack.onFail("你未输入任何信息，请重试");
        }
        else{
            this.flag=this.getPassword.updatePassword(this.password,oldPassword);
        }
        if(this.flag){
            callBack.onSuccess("修改成功");
        }
        else{
            callBack.onFail("修改失败，请重试");
        }
    }
    @Override
    public void handleDeletePassword(ValueCallBack<String> callBack){
        if(this.password.getName().isEmpty()&&
                this.password.getAccount().isEmpty()&&
                this.password.getPassword().isEmpty()){
            callBack.onFail("删除失败，请重试");
            this.flag=false;
        }
        else{
            this.flag=this.getPassword.deletePassword(this.password);
        }
        if(this.flag){
            callBack.onSuccess("删除成功");
        }
        else{
            callBack.onFail("删除失败，请重试");
        }
    }
}
