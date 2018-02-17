package com.example.cartoon.passwordmanager.Password.Main;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePassword.HandlePassword;
import com.example.cartoon.passwordmanager.data.TablePassword.IHandlePassword;
import com.example.cartoon.passwordmanager.data.TablePassword.Password;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cartoon on 2018/1/27.
 */

public class MainPresenter extends BasePresenter<Main> implements IMainContract.Presenter{
    private IMainContract.View view;
    private IHandlePassword model;
    private List<Password> list;
    public MainPresenter(IMainContract.View view){
        this.view=view;
        this.list=new ArrayList<>();
        this.model=new HandlePassword();
    }
    @Override
    public List<Password> getAdapterData(){
        return list;
    }
    @Override
    public void initData(){
        model.handleMain(new ValueCallBack<List<Password>>() {
            @Override
            public void onSuccess(List<Password> passwords) {
                list.addAll(passwords);
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
