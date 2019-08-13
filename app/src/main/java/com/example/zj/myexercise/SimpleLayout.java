package com.example.zj.myexercise;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimpleLayout extends LinearLayout {
    public SimpleLayout(Context context,String textString) {
        super(context);
    LayoutParams rootParams=new LayoutParams(LayoutParams.MATCH_PARENT,600);
    setBackgroundColor(Color.rgb(220,220,220));
    setLayoutParams(rootParams);
    setGravity(Gravity.CENTER);

    TextView textView=new TextView(context);
    textView.setText(textString);
    textView.setTextSize(40);
    LayoutParams textViewParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
    textView.setLayoutParams(textViewParams);
    addView(textView);

    }
}
