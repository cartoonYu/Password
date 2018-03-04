package com.example.cartoon.passwordmanager.PersonalInformation.Register;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.HandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.IHandleInformation;

/**
 * Created by cartoon on 2018/2/1.
 */

public class RegisterPresenter extends BasePresenter<Register> implements IRegisterContract.Presenter{
    private IRegisterContract.View view;
    private IHandleInformation model;
    //question,answer,password,passwordForConfirm都是从View层输入获取而来
    private String question;
    private String answer;
    private String password;
    private String passwordForConfirm;

    public RegisterPresenter(IRegisterContract.View view){
        this.view=view;
        this.model=new HandleInformation();
    }
    @Override
    public void addInformation(){
        if(passwordForConfirm.equals(password)){
            model.setInformation(password,question,answer);
            model.addInformation(new ValueCallBack<String>() {
                @Override
                public void onSuccess(String code) {
                    view.showToast(code);
                    view.intentToMain();
                }

                @Override
                public void onFail(String code) {
                    view.showToast(code);
                }
            });
        }
        else{
            view.showToast("两次输入的密码不相符，请重试");
        }
    }
    @Override
    public void getDataFromView(String question,String answer,String password,String passwordForConfirm){
        this.question=question;
        this.password=password;
        this.answer=answer;
        this.passwordForConfirm=passwordForConfirm;
    }
}
