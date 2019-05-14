package com.example.darianvereen.myapplication2018.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.example.darianvereen.myapplication2018.Outfit;
import com.example.darianvereen.myapplication2018.R;

public class PantsActivity extends AppCompatActivity {




    Animation alphaAnimation;
    Animation rotateAnimation;
    Animation scaleAnimation;
    Animation setAnimation;
    Animation transposeAnimation;


    @BindView(R.id.imageView_pants1)
    ImageView imageViewer;

    @OnClick(R.id.pantsBtn)
    public void doAll(){
        int resId2 = (int) imageViewer.getTag();
        Outfit.resId2 = resId2;

      imageViewer.startAnimation(alphaAnimation);

    }

    @OnClick(R.id.pantsBtn2)
    public void goBack(){
        Toast.makeText(PantsActivity.this,"Swipe Right to Continue", Toast.LENGTH_SHORT).show();
        PantsActivity.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pants);
        ButterKnife.bind(this);
        //We need an object to hold our view that's in xml
        ImageView imageView  = (ImageView)findViewById(R.id.imageView_pants1);
        TextView textView = (TextView)findViewById(R.id.textView_pants1);
        // textView1 = (TextView)findViewById(R.id.shirts_layout_text);
        //The following lines of code retrieve the information sent in the intent so we can populate the views
        //displayed on this activity with those same pictures and phrases
        imageView.setImageResource(getIntent().getIntExtra("Picture",R.drawable.pants1));
        textView.setText(getIntent().getStringExtra("Item Name"));
        //Passing an object that implements the runnable method
        //thread = new Thread(new myThread());
        initialAnimation();


        //This sets the id of the drawable.img aka the shoe we want so that
        //each different shoe that appears ..imageview will recieve its tag and
        //we will be able to fetch it elsewhere
        imageViewer.setTag(getIntent().getIntExtra("Picture",R.drawable.pants1));
    }





    private void initialAnimation() {

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
        transposeAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);

    }

}
