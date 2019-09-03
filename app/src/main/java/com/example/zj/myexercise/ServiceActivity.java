package com.example.zj.myexercise;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ServiceActivity extends Activity {
    private final String TAG="ServiceActivity";
    private LinearLayout rootLayout;
    private Button mBtnBind;
    private Button mBtnUnbind;
    private Button mBtnGetData;
    TestService.MyBinder binder;
    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder= (TestService.MyBinder) iBinder;
            Log.e(TAG,"======ServiceConnected======");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e(TAG,"======ServiceDisconnected======");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initView();
        final Intent intent=new Intent(this,TestService.class);
        mBtnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent,conn, Service.BIND_AUTO_CREATE);
            }
        });

        mBtnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
            }
        });

        mBtnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ServiceActivity.this,"Service中的count值为："+binder.getCount(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(){
        rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        mBtnBind=new Button(this);
        mBtnBind.setText("绑定服务");
        rootLayout.addView(mBtnBind);

        mBtnUnbind=new Button(this);
        mBtnUnbind.setText("解绑服务");
        rootLayout.addView(mBtnUnbind);

        mBtnGetData=new Button(this);
        mBtnGetData.setText("获取服务里的线程数据");
        rootLayout.addView(mBtnGetData);

    }


}