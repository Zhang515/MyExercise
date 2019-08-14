package com.example.zj.myexercise;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

@SuppressLint("ValidFragment")
public class MyListFragment extends Fragment {
    private List<Information> mData;
    private Context mContext;
    private FragmentManager fragmentManager;
    private int listViewId=300001;
    private int frameLayoutId=200001;

    public MyListFragment(Context mContext,FragmentManager fragmentManager,List<Information> mData){
        this.mContext=mContext;
        this.fragmentManager=fragmentManager;
        this.mData=mData;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=new MyListFragmentLayout(mContext);
        final ListView listView=view.findViewById(listViewId);
        MyAdapter myAdapter=new MyAdapter((LinkedList<Information>) mData,mContext);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("ZJ","==被点击了=="+i);
                android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                MyContentFragment myContentFragment=new MyContentFragment(mContext);
                Bundle bundle=new Bundle();
                bundle.putString("title",mData.get(i).getTitle());
                myContentFragment.setArguments(bundle);
                fragmentTransaction.replace(frameLayoutId,myContentFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
