package com.example.cartoon.passwordmanager.login;


import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.HandleInformationModel;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.IPersonalInformation;

/**
 * Created by cartoon on 2018/1/31.
 */

public class LoginPresenter extends BasePresenter<Login> implements ILoginContract.Presenter{
    private ILoginContract.View view;
    private IPersonalInformation model;

    private String password;
    private static int flag;

    public LoginPresenter(ILoginContract.View view){
        this.view=view;
        this.model=new HandleInformationModel();
        this.password="";
        this.flag=0;
    }
    @Override
    public void initData(){
    }
    @Override
    public void contrastInformation(){
        model.setInformation(password,"","");
        model.contrastInformation(new ValueCallBack.loginCallBack() {
            @Override
            public void onSuccess(String code) {
                view.showToast(code);
            }

            @Override
            public void onFail(String code) {
                view.showToast(code);
            }
        });
    }
    @Override
    public void getDataFromView(String password){
        if(password.equals("-1")&&this.password.length()!=0){
            this.password=this.password.substring(0,this.password.length()-1);
        }
        else{
            if(password.equals("-1")&&this.password.length()==0){

            }
            else{
                this.password=this.password+password;
            }

        }
        flag=this.password.length();
        if(flag==6){
            flag=0;
            contrastInformation();
        }
    }
    @Override
    public int changeView(){
        return flag;
    }
    @Override
    public int intentView() {
        return model.getState();
    }
    @Override
    public String returnPassword(){
        return this.password;
    }
}
