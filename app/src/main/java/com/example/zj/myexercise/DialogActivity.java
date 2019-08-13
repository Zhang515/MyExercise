package com.example.zj.myexercise;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTheme(R.style.Theme_AppCompat_Light_Dialog);
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        UserPWDLayout userPWDLayout =new UserPWDLayout(this);
        LinearLayout.LayoutParams userPWDParams=new LinearLayout.LayoutParams(1000, LinearLayout.LayoutParams.WRAP_CONTENT);
        userPWDParams.gravity=Gravity.CENTER_HORIZONTAL;
        userPWDLayout.setLayoutParams(userPWDParams);
        rootLayout.addView(userPWDLayout);
    }
}
