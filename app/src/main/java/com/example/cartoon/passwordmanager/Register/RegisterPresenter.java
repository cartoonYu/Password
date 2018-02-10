package com.example.cartoon.passwordmanager.Register;

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
    public int addInformation(){
        if(passwordForConfirm.equals(password)){
            model.setInformation(password,question,answer);
            model.addInformation(new ValueCallBack<String>() {
                @Override
                public void onSuccess(String code) {
                    view.showToast(code);
                }

                @Override
                public void onFail(String code) {
                    view.showToast(code);
                }
            });
            return 1;
        }
        else{
            view.showToast("两次输入的密码不相符，请重试");
            return 0;
        }
    }
    @Override
    public void initData(){
    }
    @Override
    public void getDataFromView(String question,String answer,String password,String passwordForConfirm){
        this.question=question;
        this.password=password;
        this.answer=answer;
        this.passwordForConfirm=passwordForConfirm;
    }
}
