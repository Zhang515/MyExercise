package com.example.zj.myexercise;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zj.myexercise.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends Activity {
    private ViewPager viewPager;
    private ViewPager layoutPager;
    private List<View> viewPagers;
    private List<View> layoutPagers;
    private ImageView[] imageViews;
    private ImageView[] layoutViews;
    private LinearLayout rootLayout;
    private MyButton mBtnTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initView();
        initView1();
        initLine();
        initView2();
    }

    private void initView(){
        rootLayout=new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams rootParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rootParams.setMargins(DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10));
        rootParams.gravity= Gravity.CENTER_HORIZONTAL;
        rootLayout.setLayoutParams(rootParams);
        setContentView(rootLayout);
    }

    private void initView1(){
        viewPager=new ViewPager(this);
        LinearLayout.LayoutParams viewPagerParams=new LinearLayout.LayoutParams(1000,600);
        viewPagerParams.gravity=Gravity.CENTER_HORIZONTAL;
        viewPager.setLayoutParams(viewPagerParams);
        rootLayout.addView(viewPager);

        ImageView image0=new ImageView(this);
        image0.setImageResource(R.drawable.image3);
        image0.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView image1=new ImageView(this);
        image1.setImageResource(R.drawable.image1);
        image1.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView image2=new ImageView(this);
        image2.setImageResource(R.drawable.image2);
        image2.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView image3=new ImageView(this);
        image3.setImageResource(R.drawable.image3);
        image3.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView image4=new ImageView(this);
        image4.setImageResource(R.drawable.image1);
        image4.setScaleType(ImageView.ScaleType.FIT_XY);

        viewPagers=new ArrayList<>();
        viewPagers.add(0,image0);
        viewPagers.add(1,image1);
        viewPagers.add(2,image2);
        viewPagers.add(3,image3);
        viewPagers.add(4,image4);

        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewPagers.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                viewPager.removeView(viewPagers.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = viewPagers.get(position);
                viewPager.addView(view);
                return view;
            }

            @Override
            public void finishUpdate(@NonNull ViewGroup container) {
                super.finishUpdate(container);
                int position = viewPager.getCurrentItem();
                if (position == 0) {
                    position = viewPagers.size() - 2;
                    viewPager.setCurrentItem(position, false);
                } else if (position == viewPagers.size() - 1) {
                    position = 1;
                    viewPager.setCurrentItem(position, false);
                }
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1,false);

        LinearLayout selectBox=new LinearLayout(this);
        selectBox.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams selectBoxParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        selectBoxParams.gravity=Gravity.CENTER_HORIZONTAL;
        selectBox.setLayoutParams(selectBoxParams);
        rootLayout.addView(selectBox);

        imageViews=new ImageView[viewPagers.size()-2];
        for (int i=0;i<imageViews.length;i++){
            ImageView imageView=new ImageView(this);
            LinearLayout.LayoutParams ivParams=new LinearLayout.LayoutParams(DensityUtil.dip2px(this,20),DensityUtil.dip2px(this,20));
            ivParams.setMargins(DensityUtil.dip2px(this,5),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,5));
            imageView.setLayoutParams(ivParams);
            imageView.setBackgroundColor(Color.GRAY);
            imageViews[i]=imageView;
            selectBox.addView(imageViews[i]);
        }
        imageViews[0].setBackgroundColor(Color.BLACK);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int currentPosition;
                if (i==viewPagers.size()-1){
                    currentPosition=1;
                }else if (i==0){
                    currentPosition=viewPagers.size()-2;
                }else {
                    currentPosition=i;
                }
                for (ImageView imageView : imageViews) {
                    imageView.setBackgroundColor(Color.GRAY);
                }
                imageViews[currentPosition-1].setBackgroundColor(Color.BLACK);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initView2(){
        layoutPager=new ViewPager(this);
        LinearLayout.LayoutParams viewPagerParams=new LinearLayout.LayoutParams(1000,600);
        viewPagerParams.gravity=Gravity.CENTER_HORIZONTAL;
        layoutPager.setLayoutParams(viewPagerParams);
        rootLayout.addView(layoutPager);

        SimpleLayout layout0=new SimpleLayout(this,"三");
        SimpleLayout layout1=new SimpleLayout(this,"一");
        SimpleLayout layout2=new SimpleLayout(this,"二");
        SimpleLayout layout3=new SimpleLayout(this,"三");
        SimpleLayout layout4=new SimpleLayout(this,"一");
        layoutPagers=new ArrayList<>();
        layoutPagers.add(0,layout0);
        layoutPagers.add(1,layout1);
        layoutPagers.add(2,layout2);
        layoutPagers.add(3,layout3);
        layoutPagers.add(4,layout4);

        PagerAdapter layoutAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return layoutPagers.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                layoutPager.removeView(layoutPagers.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = layoutPagers.get(position);
                layoutPager.addView(view);
                return view;
            }

            @Override
            public void finishUpdate(@NonNull ViewGroup container) {
                super.finishUpdate(container);
                int position = layoutPager.getCurrentItem();
                if (position == 0) {
                    position = layoutPagers.size() - 2;
                    layoutPager.setCurrentItem(position, false);
                } else if (position == layoutPagers.size() - 1) {
                    position = 1;
                    layoutPager.setCurrentItem(position, false);
                }
            }
        };

        layoutPager.setAdapter(layoutAdapter);
        layoutPager.setCurrentItem(1,false);

        LinearLayout selectBox1=new LinearLayout(this);
        selectBox1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams selectBoxParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        selectBoxParams.gravity=Gravity.CENTER_HORIZONTAL;
        selectBox1.setLayoutParams(selectBoxParams);
        rootLayout.addView(selectBox1);

        layoutViews=new ImageView[viewPagers.size()-2];
        for (int i=0;i<layoutViews.length;i++){
            ImageView imageView=new ImageView(this);
            LinearLayout.LayoutParams ivParams=new LinearLayout.LayoutParams(DensityUtil.dip2px(this,20),DensityUtil.dip2px(this,20));
            ivParams.setMargins(DensityUtil.dip2px(this,5),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,10),DensityUtil.dip2px(this,5));
            imageView.setLayoutParams(ivParams);
            imageView.setBackgroundColor(Color.GRAY);
            layoutViews[i]=imageView;
            selectBox1.addView(layoutViews[i]);
        }
        layoutViews[0].setBackgroundColor(Color.BLACK);

        layoutPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int currentPosition;
                if (i==layoutPagers.size()-1){
                    currentPosition=1;
                }else if (i==0){
                    currentPosition=layoutPagers.size()-2;
                }else {
                    currentPosition=i;
                }
                for (ImageView imageView : layoutViews) {
                    imageView.setBackgroundColor(Color.GRAY);
                }
                layoutViews[currentPosition-1].setBackgroundColor(Color.BLACK);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initLine(){
        View lineView=new View(this);
        LinearLayout.LayoutParams lineParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(this,5));
        lineView.setBackgroundColor(Color.BLACK);
        lineParams.setMargins(0,40,0,40);
        lineView.setLayoutParams(lineParams);
        rootLayout.addView(lineView);
    }


}
