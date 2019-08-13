package com.example.zj.myexercise;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zj.myexercise.util.DensityUtil;

public class ListViewItemLayout extends RelativeLayout {

    public ListViewItemLayout(Context context) {
        super(context);

        LayoutParams rootParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        setLayoutParams(rootParams);

        TextView leftTv=new TextView(context);
        int leftTVId = 10001;
        leftTv.setId(leftTVId);
        leftTv.setBackgroundColor(Color.LTGRAY);
        RelativeLayout.LayoutParams leftParams=new RelativeLayout.LayoutParams(DensityUtil.dip2px(context,60),DensityUtil.dip2px(context,60));
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        leftTv.setLayoutParams(leftParams);
        addView(leftTv);

        TextView themeTV=new TextView(context);
        leftTv.setGravity(Gravity.CENTER);
        int themeTVId = 10002;
        themeTV.setId(themeTVId);
        RelativeLayout.LayoutParams themeParams=new RelativeLayout.LayoutParams(DensityUtil.dip2px(context,40),DensityUtil.dip2px(context,60));
        themeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        themeParams.addRule(RelativeLayout.RIGHT_OF,leftTv.getId());
        themeTV.setLayoutParams(themeParams);
        addView(themeTV);

        Button jumpBtn=new Button(context);
        jumpBtn.setGravity(Gravity.CENTER);
        jumpBtn.setText("跳转");
        int jumpBtnId = 10003;
        jumpBtn.setId(jumpBtnId);
        LayoutParams jumpBtnParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        jumpBtnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        jumpBtnParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        jumpBtn.setLayoutParams(jumpBtnParams);
        addView(jumpBtn);
    }
}
