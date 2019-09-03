package com.example.zj.myexercise;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class TestService extends Service{
    private final String TAG="TestService";
    private int count;
    private boolean quit;

    private MyBinder binder=new MyBinder();
    public class MyBinder extends Binder{
        public int getCount(){
            return count;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind方法被调用");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreat方法被调用");
        new Thread(){
            @Override
            public void run() {
                while (!quit){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind方法被调用");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit=true;
        Log.e(TAG,"onDestroy方法被调用");
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG,"onRebind方法被调用");
    }
}
