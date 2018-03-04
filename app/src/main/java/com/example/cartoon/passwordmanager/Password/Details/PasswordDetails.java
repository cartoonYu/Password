package com.example.cartoon.passwordmanager.Password.Details;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Main.Main;
import com.example.cartoon.passwordmanager.Password.Revamp.PasswordRevamp;
import com.example.cartoon.passwordmanager.R;
import com.example.cartoon.passwordmanager.data.TablePassword.Password;

/**
 * Created by cartoon on 2018/2/11.
 */

public class PasswordDetails extends BaseActivity<PasswordDetailsPresenter>
        implements IPasswordDetails.View, View.OnClickListener{
    private TextView back;
    private TextView details;
    private TextView account;
    private TextView password;
    private TextView revamp;
    private TextView delete;

    private Intent intent;
    private Password passwordFromLast;

    private PopupWindow popupWindow;
    // 声明PopupWindow对应的视图
    private View popupView;

    // 声明平移动画
    private TranslateAnimation animation;

    @Override
    protected PasswordDetailsPresenter initPresent(){
        return new PasswordDetailsPresenter(this);
    }
    @Override
    protected int getLayout(){
        return R.layout.passworddetails;
    }
    @Override
    protected void initView(){
        back=findViewById(R.id.toolbarBack);
        details=findViewById(R.id.toolbarTag);
        account=findViewById(R.id.passwordDetailsAccount);
        password=findViewById(R.id.passwordDetailsPassword);
        revamp=findViewById(R.id.passwordDetailsRevamp);
        delete=findViewById(R.id.passwordDetailsDelete);
        passwordFromLast=(Password)getIntent().getSerializableExtra("data");
        details.setText(passwordFromLast.getName());
        account.setText(passwordFromLast.getAccount());
        password.setText(passwordFromLast.getPassword());
    }
    @Override
    protected void onPrepare(){
        back.setOnClickListener(this);
        revamp.setOnClickListener(this);
        delete.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.toolbarBack:{
                handleClickBack();
                break;
            }
            case R.id.passwordDetailsRevamp:{
                handleClickRevamp();
                break;
            }
            case R.id.passwordDetailsDelete:{
                handleClickDelete();
                break;
            }
        }
    }
    @Override
    public void handleClickBack(){
        intent=new Intent(this,Main.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void handleClickRevamp(){
        intent=new Intent(this,PasswordRevamp.class);
        intent.putExtra("dataFromDetails",passwordFromLast);
        startActivity(intent);
        finish();
    }
    @Override
    public void handleClickDelete(){
        if(popupWindow==null){
            popupView=View.inflate(this,R.layout.passworddetailsdelete,null);
            popupWindow=new PopupWindow(popupView,
                    WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                }
            });
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            animation=new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,
                    Animation.RELATIVE_TO_PARENT,1);
            animation.setInterpolator(new AccelerateInterpolator());
            animation.setDuration(200);
            popupView.findViewById(R.id.passwordDetailsDeleteConfirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    basePresenter.handleDelete();
                    popupWindow.dismiss();
                }
            });
            popupView.findViewById(R.id.passwordDetailsDeleteCancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
        }
        if(popupWindow.isShowing()){
            popupWindow.dismiss();
        }
        popupWindow.showAtLocation(this.findViewById(R.id.passwordDetails),
                Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
        popupView.startAnimation(animation);
    }
    @Override
    public void onBackPressed(){
        handleClickBack();
    }
    @Override
    public void showToast(String code){
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
    }
    @Override
    public Password getPassword(){
        return this.passwordFromLast;
    }
}
