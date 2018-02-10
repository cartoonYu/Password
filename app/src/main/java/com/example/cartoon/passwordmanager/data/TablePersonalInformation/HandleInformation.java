package com.example.cartoon.passwordmanager.data.TablePersonalInformation;

import com.example.cartoon.passwordmanager.ValueCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cartoon on 2018/1/31.
 */

public class HandleInformation implements IHandleInformation {

    private GetInformation getInformation;
    private List<PersonalInformation> informations;
    private PersonalInformation information;

    public HandleInformation(){
        this.getInformation=new GetInformation();
        this.informations=new ArrayList<>();
    }
    @Override
    public void setInformation(String password,String question,String answer){
        this.information=new PersonalInformation(password,question,answer);
    }
    @Override
    public void addInformation(ValueCallBack callBack){
        boolean flag=getInformation.addInformation(information);
        if(flag){
            callBack.onSuccess("注册成功");
        }
        else{
            callBack.onFail("注册失败，请重试");
        }
    }
    @Override
    public void handleLogin(ValueCallBack<String> callBack){
        informations=getInformation.getInformation();
        PersonalInformation temp;
        if(informations.isEmpty()){
            callBack.onFail("用户未注册");
        }
        else{
            temp=new PersonalInformation
                    (informations.get(0).getPassword(),
                            informations.get(0).getQuestion(),informations.get(0).getAnswer());
            if(temp.getPassword().equals(information.getPassword())){
                callBack.onSuccess("登录成功");
            }
            else{
                callBack.onFail("登录失败，请重试");
            }
        }
    }
    @Override
    public void getInformation(ValueCallBack<PersonalInformation> callBack){
        informations=getInformation.getInformation();
        PersonalInformation temp=new PersonalInformation
                (informations.get(0).getPassword(),
                        informations.get(0).getQuestion(),informations.get(0).getAnswer());
        if(temp.getQuestion().isEmpty()){
            callBack.onFail("用户没有设置问题内容");
        }
        else{
            callBack.onSuccess(temp);
        }
    }
}
