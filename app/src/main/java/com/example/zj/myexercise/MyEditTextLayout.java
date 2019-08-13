package com.example.zj.myexercise;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.zj.myexercise.util.DensityUtil;

public class MyEditTextLayout extends LinearLayout {
    private int userTextId=10001;
    public MyEditTextLayout(Context context,String hintString) {
        super(context);
        initView(context,hintString);
    }

    private void initView(Context context,String hintString){
        LayoutParams rootParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        setLayoutParams(rootParams);
        setOrientation(VERTICAL);

        RelativeLayout editTextLayout=new RelativeLayout(context);
        RelativeLayout.LayoutParams editTextParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        editTextParams.setMargins(0,0,0,20);
        editTextLayout.setLayoutParams(editTextParams);
        editTextLayout.setFocusable(true);
        editTextLayout.setFocusableInTouchMode(true);
        addView(editTextLayout);

        final EditText userText=new EditText(context);
        RelativeLayout.LayoutParams userTextParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        userTextParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        userText.setLayoutParams(userTextParams);
        userText.setHint(hintString);
        userText.setTextSize(20);
        userText.setBackgroundColor(0xFFFFFFFF);
        userText.setId(userTextId);
        editTextLayout.addView(userText);

        final Button clearButton=new Button(context);
        RelativeLayout.LayoutParams clearBtnParams=new RelativeLayout.LayoutParams(50,50);
        clearBtnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        clearBtnParams.addRule(RelativeLayout.CENTER_VERTICAL);
        clearBtnParams.setMargins(0,0,50,0);
        GradientDrawable gradientDrawable=new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);
        gradientDrawable.setCornerRadius(25);
        clearButton.setBackground(gradientDrawable);
        clearButton.setLayoutParams(clearBtnParams);
        editTextLayout.addView(clearButton);
        clearButton.setVisibility(INVISIBLE);

        final View lineView=new View(context);
        RelativeLayout.LayoutParams lineParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(context,3));
        lineParams.addRule(RelativeLayout.BELOW,userText.getId());
        lineView.setLayoutParams(lineParams);
        lineView.setBackgroundColor(Color.LTGRAY);
        editTextLayout.addView(lineView);

        userText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    lineView.setBackgroundColor(Color.BLUE);
                }else {
                    lineView.setBackgroundColor(Color.LTGRAY);
                }
            }
        });

        userText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(userText.getText().toString().trim())){
                    clearButton.setVisibility(VISIBLE);
                }else {
                    clearButton.setVisibility(INVISIBLE);
                }
            }
        });

        clearButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                userText.setText("");
            }
        });
    }
}
