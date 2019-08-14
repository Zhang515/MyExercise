package com.example.zj.myexercise;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MyContentFragment extends Fragment {
    private Context mContext;
    private int textvId=400001;

    @SuppressLint("ValidFragment")
    MyContentFragment(Context mContext){
        this.mContext=mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=new MyContentFragmentLayout(mContext);
        TextView textView=view.findViewById(textvId);
        textView.setText(getArguments().getString("title"));
        return view;
    }
}
