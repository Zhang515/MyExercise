package com.example.zj.myexercise;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

public class ValidVodeEditText extends android.support.v7.widget.AppCompatEditText {
    public ValidVodeEditText(Context context,boolean isFirstItem) {
        super(context);
        setGravity(Gravity.CENTER);
        setTextSize(14f);
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });


    }
}
