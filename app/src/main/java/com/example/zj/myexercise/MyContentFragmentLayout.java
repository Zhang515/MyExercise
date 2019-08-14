package com.example.zj.myexercise;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyContentFragmentLayout extends LinearLayout{
    private TextView textView;
    private int textvId=400001;

    public MyContentFragmentLayout(Context context) {
        super(context);
        LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        textView=new TextView(context);
        LayoutParams textParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        textParams.gravity= Gravity.CENTER;
        textView.setLayoutParams(textParams);
        textView.setId(textvId);
        textView.setTextSize(30);
        addView(textView);
    }
}
