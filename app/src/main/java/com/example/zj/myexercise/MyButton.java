package com.example.zj.myexercise;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class MyButton extends android.support.v7.widget.AppCompatButton{

    public MyButton(Context context,String textString,float textSize,float radius,int backgroundColor) {
        super(context);
        setAllCaps(false);
        setText(textString);
        setTextSize(textSize);
        GradientDrawable gradientDrawable=new GradientDrawable();
        gradientDrawable.setCornerRadius(radius);
        gradientDrawable.setColor(backgroundColor);
        setBackground(gradientDrawable);
    }

    public MyButton(Context context,String textString,float textSize,float radius,int backgroundColor,int pressedColor){
        super(context);
        setAllCaps(false);
        setText(textString);
        setTextSize(textSize);
        GradientDrawable gradientDrawable1=new GradientDrawable();
        gradientDrawable1.setColor(backgroundColor);
        gradientDrawable1.setCornerRadius(radius);
        GradientDrawable gradientDrawable2=new GradientDrawable();
        gradientDrawable2.setColor(pressedColor);
        gradientDrawable2.setCornerRadius(radius);
        int pressed=android.R.attr.state_pressed;
        StateListDrawable stateListDrawable=new StateListDrawable();
        stateListDrawable.addState(new int[]{-pressed},gradientDrawable1);
        stateListDrawable.addState(new int[]{pressed},gradientDrawable2);
        setBackground(stateListDrawable);
    }

    public MyButton(Context context,String textString,float textSize,float radius,int startChangeColor,int endChangeColor,int i){
        super(context);
        setAllCaps(false);
        int[] colors=new int[2];
        colors[0]=startChangeColor;
        colors[1]=endChangeColor;
        setText(textString);
        setTextSize(textSize);
        GradientDrawable gradientDrawable=new GradientDrawable();
        gradientDrawable.setCornerRadius(radius);
        if (i==0){
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }else{
            gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        }
        gradientDrawable.setColors(colors);
        setBackground(gradientDrawable);
    }
}
