package com.example.cartoon.passwordmanager.PersonalInformation.RevampPassword;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.HandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.IHandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.PersonalInformation;

/**
 * Created by cartoon on 2018/2/3.
 */

public class InformationRevampPasswordPresenter extends BasePresenter<InformationRevampPassword> implements IInformationRevampPasswordContract.Presenter{
    private IInformationRevampPasswordContract.View view;
    private IHandleInformation model;
    private PersonalInformation information;

    private boolean flag;
    public InformationRevampPasswordPresenter(IInformationRevampPasswordContract.View view){
        this.view=view;
        this.model=new HandleInformation();
    }
    @Override
    public void initData(){
        model.getInformation(new ValueCallBack<PersonalInformation>() {
            @Override
            public void onSuccess(PersonalInformation information) {
                view.initView(information);
            }
            @Override
            public void onFail(String code) {
                view.showToast(code);
            }
        });
    }
    @Override
    public boolean getInput(){
        model.setInformation(view.getPassword(),view.getQuestion(),view.getAnswer());
        model.handleRevampPassword(new ValueCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                view.showToast(s);
                flag=true;
            }

            @Override
            public void onFail(String code) {
                view.showToast(code);
                flag=false;
            }
        });
        return flag;
    }
}
