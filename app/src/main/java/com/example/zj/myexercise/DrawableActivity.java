package com.example.zj.myexercise;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zj.myexercise.util.DensityUtil;

public class DrawableActivity extends Activity {

    private LinearLayout rootLayout;
    private TransitionDrawable transitionDrawable;
    private MyButton mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initView();
        setListener();
    }

    private void initView(){
        rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        ImageView imageView=new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,600));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        transitionDrawable=new TransitionDrawable(new Drawable[]{
                ResourcesCompat.getDrawable(getResources(),R.drawable.image1,null),
                ResourcesCompat.getDrawable(getResources(),R.drawable.image2,null)});
        imageView.setImageDrawable(transitionDrawable);
        rootLayout.addView(imageView);

        mBtnStart=new MyButton(this,"开始",18, DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        LinearLayout.LayoutParams btnParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnParams.setMargins(0,DensityUtil.dip2px(this,20),0,0);
        mBtnStart.setLayoutParams(btnParams);
        rootLayout.addView(mBtnStart);
    }

    private void setListener(){
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transitionDrawable.startTransition(3000);
            }
        });
    }
}
