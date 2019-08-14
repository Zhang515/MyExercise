package com.example.zj.myexercise;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class MyAdapter extends BaseAdapter {
    private LinkedList<Information> mData;
    private Context mContext;
    protected int leftTVId=10001;
    protected int themeTVId=10002;
    protected int jumpBtnId=10003;

    public MyAdapter(LinkedList<Information> mData, Context mContext){
        this.mData=mData;
        this.mContext=mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view==null){
            view=new ListViewItemLayout(mContext);
            holder=new ViewHolder();
            holder.leftTV=view.findViewById(leftTVId);
            holder.themeTV=view.findViewById(themeTVId);
            holder.jumpBtn=view.findViewById(jumpBtnId);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.leftTV.setText(mData.get(i).getTitle());
        holder.themeTV.setText(mData.get(i).getTheme());
        holder.jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse(mData.get(i).getUrl());
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    static class ViewHolder{
        TextView leftTV;
        TextView themeTV;
        Button jumpBtn;
    }

}
