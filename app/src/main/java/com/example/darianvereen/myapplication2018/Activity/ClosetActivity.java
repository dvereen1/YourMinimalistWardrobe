package com.example.darianvereen.myapplication2018.Activity;

import android.animation.ValueAnimator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darianvereen.myapplication2018.Adapater.MyViewPagerAdapater;
import com.example.darianvereen.myapplication2018.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClosetActivity extends AppCompatActivity {


    private MyViewPagerAdapater adapater = new MyViewPagerAdapater(getSupportFragmentManager());



    @BindView(R.id.closet_activity_viewpager)
    ViewPager viewPager;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet);
        ButterKnife.bind(this);

        viewPager = findViewById(R.id.closet_activity_viewpager);
        //set adapter
        viewPager.setAdapter(adapater);


        //the adapter provides the pages for the view pager to scroll through
    }






}
