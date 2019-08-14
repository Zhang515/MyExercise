package com.example.zj.myexercise;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zj.myexercise.util.DensityUtil;

import java.util.LinkedList;
import java.util.List;

public class FragmentActivity extends Activity {
    private RelativeLayout rootLayout;
    private ListView listView;
    private int frameLayoutId=200001;
    private int textId=200002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        rootLayout=new RelativeLayout(this);
        RelativeLayout.LayoutParams rootParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        FrameLayout frameLayout=new FrameLayout(this);
        RelativeLayout.LayoutParams frameParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        frameParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        frameParams.addRule(RelativeLayout.ABOVE,textId);
        frameLayout.setLayoutParams(frameParams);
        frameLayout.setId(frameLayoutId);
        rootLayout.addView(frameLayout);

        listView=new ListView(this);
        List<Information> mData=new LinkedList<Information>();
        mData.add(new Information("第1页","百度","https://www.baidu.com/"));
        mData.add(new Information("第2页","搜狗","https://www.sogou.com/"));
        mData.add(new Information("第3页","百度","https://www.baidu.com/"));
        mData.add(new Information("第4页","搜狗","https://www.sogou.com/"));
        mData.add(new Information("第5页","百度","https://www.baidu.com/"));
        mData.add(new Information("第6页","搜狗","https://www.sogou.com/"));
        mData.add(new Information("第7页","百度","https://www.baidu.com/"));
        mData.add(new Information("第8页","搜狗","https://www.sogou.com/"));
        mData.add(new Information("第9页","百度","https://www.baidu.com/"));
        mData.add(new Information("第10页","搜狗","https://www.sogou.com/"));
        mData.add(new Information("第11页","百度","https://www.baidu.com/"));
        mData.add(new Information("第12页","搜狗","https://www.sogou.com/"));

        android.app.FragmentManager fragmentManager=getFragmentManager();

        MyListFragment myListFragment=new MyListFragment(this,fragmentManager,mData);
        android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayoutId,myListFragment);
        fragmentTransaction.commit();

        TextView textView=new TextView(this);
        RelativeLayout.LayoutParams textParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        textParams.addRule(RelativeLayout.BELOW,frameLayoutId);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textView.setLayoutParams(textParams);
        textView.setText("这是底部导航栏");
        textView.setTextSize(40);
        textView.setBackgroundColor(Color.LTGRAY);
        textView.setId(textId);
        rootLayout.addView(textView);



    }


}
