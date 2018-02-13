package com.example.cartoon.passwordmanager.Password.Details;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePassword.DeletePasswordModel;
import com.example.cartoon.passwordmanager.data.TablePassword.IDeletePassword;

/**
 * Created by cartoon on 2018/2/11.
 */

class PasswordDetailsPresenter extends BasePresenter<PasswordDetails> implements IPasswordDetails.Presenter{
    private IPasswordDetails.View view;
    private IDeletePassword model;
    private boolean flag;
    public PasswordDetailsPresenter(IPasswordDetails.View view){
        this.view=view;
        this.model=new DeletePasswordModel();
    }
    @Override
    public void initData(){
    }
    @Override
    public boolean handleDelete(){
        model.setPassword(view.getPassword());
        model.deletePassword(new ValueCallBack<String>() {
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
