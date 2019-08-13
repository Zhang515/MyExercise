package com.example.zj.myexercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.zj.myexercise.util.DensityUtil;

public class ValidVodeActivity extends Activity {
    private LinearLayout rootLayout;
    private int vcLength;
    private LinearLayout validCodeLayout;
    private EditText[] editTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        super.onCreate(savedInstanceState);
        initView();

        Intent intent=getIntent();
        vcLength=Integer.parseInt(intent.getStringExtra("validLength"));
        initValidView(vcLength);
        editTexts[0].requestFocus();
    }

    private void initView(){
        rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        validCodeLayout=new LinearLayout(this);
        LinearLayout.LayoutParams validCLParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        validCLParams.setMargins(DensityUtil.dip2px(this,20),0,DensityUtil.dip2px(this,20),0);
        validCodeLayout.setOrientation(LinearLayout.HORIZONTAL);
        validCodeLayout.setFocusable(true);
        validCodeLayout.setFocusableInTouchMode(true);
        rootLayout.addView(validCodeLayout,validCLParams);
    }

    private void initValidView(final int vcLength){

        editTexts=new EditText[vcLength];
        for (int i=0;i<vcLength;i++){
            editTexts[i]=new EditText(this);
            int leftMatgin=i==0?0:DensityUtil.dip2px(this,10);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.weight=1;
            params.leftMargin=leftMatgin;
            editTexts[i].setLayoutParams(params);
            editTexts[i].setGravity(Gravity.CENTER);
            editTexts[i].setInputType(InputType.TYPE_CLASS_PHONE);
            editTexts[i].setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            editTexts[i].setTextSize(16);
            final int finalI = i;
            editTexts[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable!=null && editable.length()==1){
                        if (finalI <vcLength-1){
                            editTexts[finalI+1].requestFocusFromTouch();
                        }
                    }
                }
            });
            if (i!=0){
                editTexts[i].setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if ((((EditText)view).getText().toString()==null || ((EditText)view).getText().toString().isEmpty()) && i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                            editTexts[finalI-1].getText().clear();
                            editTexts[finalI-1].requestFocusFromTouch();
                        }
                        return false;
                    }
                });
            }
            validCodeLayout.addView(editTexts[i]);
        }
    }

}
