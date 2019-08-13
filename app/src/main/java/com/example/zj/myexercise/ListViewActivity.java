package com.example.zj.myexercise;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.zj.myexercise.util.DensityUtil;

import java.util.LinkedList;
import java.util.List;

public class ListViewActivity extends Activity {
    private LinearLayout rootLayout;
    private ListView simpleListView;
    private ListView listView;
    private Button mBtnValidCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.setMargins(DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10));
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);

        simpleListView=new ListView(this);
        String[] strings={"A","B","C","D"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,strings);
        simpleListView.setAdapter(adapter);
        rootLayout.addView(simpleListView);

        View lineView=new View(this);
        LinearLayout.LayoutParams lineParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(this,5));
        lineView.setBackgroundColor(Color.BLACK);
        lineParams.setMargins(0,40,0,40);
        lineView.setLayoutParams(lineParams);
        rootLayout.addView(lineView);

        listView=new ListView(this);
        List<Information> mData=new LinkedList<Information>();
        mData.add(new Information("第一页","百度","https://www.baidu.com/"));
        mData.add(new Information("第二页","搜狗","https://www.sogou.com/"));
        MyAdapter adapter1=new MyAdapter((LinkedList<Information>) mData,this);
        listView.setAdapter(adapter1);
        rootLayout.addView(listView);

        final EditText validLengthET=new EditText(this);
        LinearLayout.LayoutParams vcParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        validLengthET.setLayoutParams(vcParams);
        rootLayout.addView(validLengthET);

        mBtnValidCode=new MyButton(this,"ValidCode",18,DensityUtil.dip2px(this,20), Color.rgb(135,206,250));
        LinearLayout.LayoutParams btnParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnParams.setMargins(0,DensityUtil.dip2px(this,20),0,0);
        mBtnValidCode.setLayoutParams(btnParams);
        rootLayout.addView(mBtnValidCode);
        mBtnValidCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ListViewActivity.this,ValidVodeActivity.class);
                intent.putExtra("validLength",validLengthET.getText().toString());
                startActivity(intent);
            }
        });
    }
}
