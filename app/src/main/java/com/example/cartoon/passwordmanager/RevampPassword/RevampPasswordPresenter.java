package com.example.cartoon.passwordmanager.RevampPassword;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.HandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.IHandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.PersonalInformation;

/**
 * Created by cartoon on 2018/2/3.
 */

public class RevampPasswordPresenter extends BasePresenter<RevampPassword> implements IRevampPasswordContract.Presenter{
    private IRevampPasswordContract.View view;
    private IHandleInformation model;
    private PersonalInformation information;
    public RevampPasswordPresenter(IRevampPasswordContract.View view){
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
}
