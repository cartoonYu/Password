package com.example.cartoon.passwordmanager.PersonalInformation.RevampQuestion;

import com.example.cartoon.passwordmanager.BasePresenter;
import com.example.cartoon.passwordmanager.ValueCallBack;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.HandleInformation;
import com.example.cartoon.passwordmanager.data.TablePersonalInformation.IHandleInformation;

/**
 * Created by cartoon on 2018/2/11.
 */

class InformationRevampQuestionPresenter extends BasePresenter<InformationRevampQuestion> implements IInformationRevampQuestion.Presenter{
    private IInformationRevampQuestion.View view;
    private IHandleInformation model;

    private static boolean flag;
    public InformationRevampQuestionPresenter(IInformationRevampQuestion.View view){
        this.view=view;
        this.model=new HandleInformation();
    }
    @Override
    public boolean getInput(){
        model.setInformation("",view.getInputQuestion(),view.getInputAnswer());
        model.handleRevampQuestion(new ValueCallBack<String>() {
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
