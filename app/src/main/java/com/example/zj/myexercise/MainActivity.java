package com.example.zj.myexercise;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.zj.myexercise.util.DensityUtil;
//    my exercise test
public class MainActivity extends Activity{
//    动态权限
    private static String[] PERMISSIONS_STORAGE = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
//            Manifest.permission.READ_PHONE_NUMBERS,
//            Manifest.permission.READ_SMS
    };
//    权限请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;

    private Button mBtnViewPager;
    private Button mBtnLayoutToggle;
    private Button mBtnListView;
    private Button mBtnWebView;
    private Button mBtnAnimation;
    private Button mBtnDialogActivity;
    private Button mBtnFragment;
    private Button mBtnDrawable;
    private Button mBtnService;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initView();
        setListener();
//        applyPermisson();
    }

    private void initView(){
        scrollView=new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        setContentView(scrollView);

        LinearLayout rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.setMargins(DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10));
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        scrollView.addView(rootLayout);

        TextView textView=new TextView(this);
        WindowManager wm = (WindowManager) this.getSystemService(this.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        textView.setText("宽度==="+width+"高度==="+height);
        rootLayout.addView(textView);

        EditText editText=new EditText(this);
        LinearLayout.LayoutParams etParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rootLayout.addView(editText,etParams);



        mBtnViewPager=new MyButton(this,"ViewPager",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        LinearLayout.LayoutParams btnParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnParams.setMargins(0,DensityUtil.dip2px(this,20),0,0);
        mBtnViewPager.setLayoutParams(btnParams);
        rootLayout.addView(mBtnViewPager);

        mBtnLayoutToggle=new MyButton(this,"LayoutToggle",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250),Color.rgb(70,130,180));
        mBtnLayoutToggle.setLayoutParams(btnParams);
        rootLayout.addView(mBtnLayoutToggle);

        mBtnListView=new MyButton(this,"ListView",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        mBtnListView.setLayoutParams(btnParams);
        rootLayout.addView(mBtnListView);

        mBtnWebView=new MyButton(this,"Webview",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        mBtnWebView.setLayoutParams(btnParams);
        rootLayout.addView(mBtnWebView);

        mBtnAnimation=new MyButton(this,"帧动画",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        mBtnAnimation.setLayoutParams(btnParams);
        rootLayout.addView(mBtnAnimation);

        mBtnDialogActivity=new MyButton(this,"DialogActivity",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        mBtnDialogActivity.setLayoutParams(btnParams);
        rootLayout.addView(mBtnDialogActivity);

        mBtnFragment=new MyButton(this,"Fragment",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        mBtnFragment.setLayoutParams(btnParams);
        rootLayout.addView(mBtnFragment);

        mBtnDrawable=new MyButton(this,"Drawable",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        mBtnDrawable.setLayoutParams(btnParams);
        rootLayout.addView(mBtnDrawable);

        mBtnService=new MyButton(this,"Service",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        mBtnService.setLayoutParams(btnParams);
        rootLayout.addView(mBtnService);

    }

    private void setListener(){
        mBtnViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        mBtnLayoutToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LayoutToggleActivity.class);
                startActivity(intent);
            }
        });

        mBtnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AnimationActivity.class);
                startActivity(intent);
            }
        });

        mBtnDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });

        mBtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(intent);
            }
        });

        mBtnDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DrawableActivity.class);
                startActivity(intent);
            }
        });

        mBtnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ServiceActivity.class);
                startActivity(intent);
            }
        });

    }

    private void applyPermisson(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);

            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }

        }
    }


}
