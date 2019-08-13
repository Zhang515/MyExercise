package com.example.zj.myexercise;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.zj.myexercise.util.DensityUtil;

public class LayoutToggleActivity extends Activity {
    private LinearLayout rootLayout;
    private UserPWDLayout userPWDLayout;
    private SmsCodeLayout smsCodeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        initUserPWDLayout();
    }

    private void initUserPWDLayout(){
        if (rootLayout.getChildCount()>0){
            rootLayout.removeAllViews();
        }
        if (userPWDLayout==null){
            newUserPWDLayout();
        }
        userPWDLayout.getChangeTV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSmsCodeLayout();
            }
        });
        rootLayout.addView(userPWDLayout);
    }

    private void initSmsCodeLayout(){
        if (rootLayout.getChildCount()>0){
            rootLayout.removeAllViews();
        }
        if (smsCodeLayout==null){
            newSmsCodeLayout();
        }
        smsCodeLayout.getChangeTV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initUserPWDLayout();
            }
        });
        rootLayout.addView(smsCodeLayout);
    }

    private void newUserPWDLayout(){
        userPWDLayout =new UserPWDLayout(this);
        LinearLayout.LayoutParams userPWDParams=new LinearLayout.LayoutParams(900, LinearLayout.LayoutParams.WRAP_CONTENT);
        userPWDParams.gravity=Gravity.CENTER_HORIZONTAL;
        userPWDLayout.setLayoutParams(userPWDParams);
    }

    private void newSmsCodeLayout(){
        smsCodeLayout =new SmsCodeLayout(this);
        LinearLayout.LayoutParams smsCodeParams=new LinearLayout.LayoutParams(900, LinearLayout.LayoutParams.WRAP_CONTENT);
        smsCodeParams.gravity=Gravity.CENTER_HORIZONTAL;
        smsCodeLayout.setLayoutParams(smsCodeParams);
    }
}
