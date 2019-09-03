package com.example.zj.myexercise;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zj.myexercise.util.DensityUtil;

public class AnimationActivity extends Activity {
    private LinearLayout rootLayout;
    private ImageView imageView;
    private Button mBtnPlay;
    private AnimationDrawable animationDrawable;
    private CountDownTimer runTimer;
    private String testString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        testString=getIntent().getStringExtra("testString");
        initView();

        animationDrawable=new AnimationDrawable();
        int[] images={R.drawable.animation1,R.drawable.animation2,R.drawable.animation3,R.drawable.animation4};
        for (int i=0;i<4;i++){
            Drawable frame=getResources().getDrawable(images[i]);
            animationDrawable.addFrame(frame,300);
        }
        animationDrawable.setOneShot(false);
        imageView.setBackground(animationDrawable);

        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBtnPlay.getText().toString().trim().equals("开始奔跑")){
                    Message msg=new Message();
                    msg.what=1;
                    mhandler.sendMessage(msg);
                }else {
                    Message msg=new Message();
                    msg.what=2;
                    mhandler.sendMessage(msg);
                }

            }
        });


    }

    private void initView(){
        rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.setMargins(DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10));
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        imageView=new ImageView(this);
        LinearLayout.LayoutParams imageParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imageParams.gravity=Gravity.CENTER;
        imageView.setLayoutParams(imageParams);
        rootLayout.addView(imageView);

        mBtnPlay=new MyButton(this,"开始奔跑",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        LinearLayout.LayoutParams btnParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnParams.setMargins(0,DensityUtil.dip2px(this,20),0,0);
        mBtnPlay.setLayoutParams(btnParams);
        rootLayout.addView(mBtnPlay);

        TextView textView=new TextView(this);
        rootLayout.addView(textView);
        textView.setText(TextUtils.isEmpty(testString)?"111":"222");
    }

    private Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                if (!animationDrawable.isRunning()){
                    animationDrawable.start();
                    runCountDowm();
                }
            }else if (msg.what==2){
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                    mBtnPlay.setText("开始奔跑");
                }
            }
        }
    };

    private void runCountDowm(){
        if (runTimer!=null){
            runTimer.cancel();
        }
        runTimer=new CountDownTimer(11*1000,1000) {
            @Override
            public void onTick(long l) {
                mBtnPlay.setEnabled(false);
                String textString=String.format("再跑%s秒才能休息",l/1000);
                mBtnPlay.setText(textString);
            }

            @Override
            public void onFinish() {
                mBtnPlay.setEnabled(true);
                mBtnPlay.setText("可以休息了");
                mBtnPlay.setClickable(true);
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (runTimer!=null){
            runTimer.cancel();
        }
        runTimer=null;
    }
}
