package com.example.zj.myexercise;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zj.myexercise.util.DensityUtil;

public class SmsCodeLayout extends RelativeLayout {
    private int userId=1000001;
    private int passwordId=1000002;
    private int loginBtnId=1000003;

    private TextView changeTV;

    public SmsCodeLayout(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context){
        LayoutParams rootParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        setLayoutParams(rootParams);

        MyEditTextLayout userNameLayout=new MyEditTextLayout(context,"请输入手机");
        LayoutParams userNameParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        userNameParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        userNameLayout.setLayoutParams(userNameParams);
        userNameLayout.setId(userId);
        addView(userNameLayout);

        MyEditTextLayout passwordLayout=new MyEditTextLayout(context,"请输入验证码");
        LayoutParams passwordParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        passwordParams.addRule(RelativeLayout.BELOW,userNameLayout.getId());
        passwordLayout.setLayoutParams(passwordParams);
        passwordLayout.setId(passwordId);
        addView(passwordLayout);

        MyButton loginBtn=new MyButton(context,"登录",20, DensityUtil.dip2px(context,20), Color.rgb(0,191,255));
        LayoutParams loginBtnParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        loginBtnParams.addRule(RelativeLayout.BELOW,passwordLayout.getId());
        loginBtnParams.setMargins(0,15,0,15);
        loginBtn.setLayoutParams(loginBtnParams);
        loginBtn.setId(loginBtnId);
        addView(loginBtn);

        changeTV=new TextView(context);
        changeTV.setText("帐密登录");
        changeTV.setTextSize(14);
        LayoutParams changeTVdParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        changeTVdParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        changeTVdParams.addRule(RelativeLayout.BELOW,loginBtn.getId());
        changeTV.setLayoutParams(changeTVdParams);
        addView(changeTV);

    }

    public TextView getChangeTV() {
        return changeTV;
    }
}
