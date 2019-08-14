package com.example.zj.myexercise;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MyListFragmentLayout extends LinearLayout {
    private int listViewId=300001;
    public MyListFragmentLayout(Context context) {
        super(context);
        LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        setOrientation(HORIZONTAL);

        ListView listView=new ListView(context);
        LayoutParams listParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        listView.setLayoutParams(listParams);
        listView.setId(listViewId);
        listView.setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        addView(listView);
    }
}
