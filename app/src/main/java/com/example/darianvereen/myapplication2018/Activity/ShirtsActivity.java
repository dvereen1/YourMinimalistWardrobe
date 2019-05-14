package com.example.darianvereen.myapplication2018.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;


import com.example.darianvereen.myapplication2018.Fragment.PantsFragment;
import com.example.darianvereen.myapplication2018.Outfit;
import com.example.darianvereen.myapplication2018.R;
import com.example.darianvereen.myapplication2018.dialog.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShirtsActivity extends AppCompatActivity {
    //Outfit outfit;
    Animation alphaAnimation;
    Animation rotateAnimation;
    Animation scaleAnimation;
    Animation setAnimation;
    Animation transposeAnimation;
    BroadcastReceiver receiver;


    @BindView(R.id.imageView_shirts1)
    ImageView imageViews;

    //int resId1 = (int) imageViews.getTag();
    @OnClick(R.id.shirtsBtn)
    public void doAll(){
        //Bundle b = new Bundle();
        int resId1 = (int) imageViews.getTag();
        imageViews.startAnimation(scaleAnimation);
        Outfit.resId1 = resId1;
        //Toast.makeText(ShirtsActivity.this,"Swipe Right to Continue", Toast.LENGTH_SHORT).show();
          // ShirtsActivity.this.finish();


    }

    @OnClick(R.id.shirtBtn2)
    public void goBack(){
        Toast.makeText(ShirtsActivity.this,"Swipe Right to Continue", Toast.LENGTH_SHORT).show();
        ShirtsActivity.this.finish();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirts);
        ButterKnife.bind(this);
        //We need an object to hold our view that's in xml
        ImageView imageView  = (ImageView)findViewById(R.id.imageView_shirts1);
        TextView textView = (TextView)findViewById(R.id.textView_shirts1);
        // textView1 = (TextView)findViewById(R.id.shirts_layout_text);
        //The following lines of code retrieve the information sent in the intent so we can populate the views
        //displayed on this activity with those same pictures and phrases
        imageView.setImageResource(getIntent().getIntExtra("Picture",R.drawable.shirt1));
        textView.setText(getIntent().getStringExtra("Item Name"));



        //This sets the id of the drawable.img aka the shoe we want so that
        //each different shoe that appears ..imageview will recieve its tag and
        //we will be able to fetch it elsewhere
        imageViews.setTag(getIntent().getIntExtra("Picture",R.drawable.shirt1));

        //resId1 = (int) imageViews.getTag();
        initialAnimation();

    }



    private void initialAnimation() {

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
        transposeAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);

    }



    public int getShirtID(int resId){
        return resId;
    }




}
