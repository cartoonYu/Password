package com.example.cartoon.passwordmanager.Main;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.GetPasswordModel;
import com.example.cartoon.passwordmanager.data.IPasswordModel;
import com.example.cartoon.passwordmanager.data.Password;

import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public class MainPresenter extends BasePresenter<Main> implements IMainContract.Presenter{
    private IMainContract.View view;
    private IPasswordModel.getPasswordModel model;
    public MainPresenter(IMainContract.View view){
        this.view=view;
        this.model=new GetPasswordModel();
    }
    @Override
    public List<Password> getAdapterData(){
        return model.getAdapterData();
    }
    @Override
    public void initData(){
        model.getAdapterData(new ValueCallBack.PasswordListCallBack<List<Password>>() {
            @Override
            public void onSuccess(List<Password> passwords) {
                model.getAdapterData().addAll(passwords);
                view.refreshAdapter();
            }
            @Override
            public void onFail(String code) {
                view.showToast(code);
                view.onEmpty();
            }
        });
    }
}
