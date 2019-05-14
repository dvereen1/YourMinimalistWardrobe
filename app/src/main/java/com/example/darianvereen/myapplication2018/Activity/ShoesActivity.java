package com.example.darianvereen.myapplication2018.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.darianvereen.myapplication2018.Outfit;
import com.example.darianvereen.myapplication2018.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoesActivity extends AppCompatActivity {


    Animation alphaAnimation;
    Animation rotateAnimation;
    Animation scaleAnimation;
    Animation setAnimation;
    Animation transposeAnimation;

    @BindView(R.id.imageView_shoes1)
    ImageView imageViews;



    //PantsFragment pantsFragment;
    @OnClick(R.id.shoesBtn)
    public void doAll(){
        int resId3 = (int) imageViews.getTag();
        Outfit.resId3  = resId3;


        Intent imgIntent = new Intent(ShoesActivity.this, FinalActivity.class);
        //imageViews.startAnimation(rotateAnimation);
        //Toast.makeText(this, "This is the shirt id: " + Outfit.resId1 + "--This is the pants id: " + Outfit.resId2 +"--This is the pants id: " +Outfit.resId3 , Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString("countdown","20");
        //imageViews.startAnimation(rotateAnimation);
        imgIntent.putExtras(bundle);
        imgIntent.setClass(this, FinalActivity.class);
        if(Outfit.resId3 != 0  && Outfit.resId2 !=0  && Outfit.resId1 !=0 ){
            startActivity(imgIntent);
            Toast.makeText(ShoesActivity.this,"You're almost done!", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(ShoesActivity.this,"You Only Gonna Wear Shoes?", Toast.LENGTH_SHORT).show();
        }


        //ShoesActivity.this.finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);
        ButterKnife.bind(this);
        //We need an object to hold our view that's in xml
        ImageView imageView  = (ImageView)findViewById(R.id.imageView_shoes1);
        TextView textView = (TextView)findViewById(R.id.textView_shoes1);
        // textView1 = (TextView)findViewById(R.id.shirts_layout_text);
        //The following lines of code retrieve the information sent in the intent so we can populate the views
        //displayed on this activity with those same pictures and phrases
        imageView.setImageResource(getIntent().getIntExtra("Picture",R.drawable.shoes1));
        textView.setText(getIntent().getStringExtra("Item Name"));
        //Passing an object that implements the runnable method
        //thread = new Thread(new myThread());
        //imageView.startAnimation(rotateAnimation);
        //This sets the id of the drawable.img aka the shoe we want so that
        //each different shoe that appears ..imageview will recieve its tag and
        //we will be able to fetch it elsewhere
        imageViews.setTag(getIntent().getIntExtra("Picture",R.drawable.shoes1));
        initialAnimation();



    }





    private void initialAnimation() {

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
        transposeAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);

    }

}
