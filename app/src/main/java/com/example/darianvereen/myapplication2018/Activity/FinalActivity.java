package com.example.darianvereen.myapplication2018.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darianvereen.myapplication2018.MainActivity;
import com.example.darianvereen.myapplication2018.Outfit;
import com.example.darianvereen.myapplication2018.R;
import com.example.darianvereen.myapplication2018.dialog.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FinalActivity extends AppCompatActivity implements View.OnTouchListener {
    Bundle bundle;
    ArrayList<Outfit> outfits;


    @BindView(R.id.textView2_final)
    TextView tv;


    private GestureDetector gestureDetector;
    private int sumX =0;
    private int sumY =0;


    Outfit outie;
    int count  = 0;


    @BindView(R.id.textView_final_activity)
    TextView textView;

    @BindView(R.id.imageView_fina_activity_bundle1)
    ImageView bundleImageView1;

    @BindView(R.id.imageView_fina_activity_bundle2)
    ImageView bundleImageView2;

    @BindView(R.id.imageView_fina_activity_bundle3)
    ImageView bundleImageView3;

    @BindView(R.id.textView_final_activity_bundle)
    TextView bundleView;

    @OnClick(R.id.button_final_yes)
    public void Submit(){

            count++;
         switch (count){
             case 1:
                 outie =  new Outfit();
                 break;
             case 2:
                 Outfit outie2 = new Outfit();
                 break;

         }

       Intent intent = new Intent(FinalActivity.this, ViewWardrobe.class);
      // intent.putExtra("day", Outfit.day);


        ///the first parameter is the key which enables uss to identify the data we want in another activity --- th
        //the second parameter is the value which can be retrieved if we use the correct key in the next activity
        //we then pass the bundle into the putExtra of the intent object to pass the data along..
        //bundle.putParcelableArrayList("weekdayOutfits", outie);
        //intent.putExtras(bundle);
        //intent.setClass(this, FinalActivity.class);
        // sendBroadcast(view);

        startActivity(intent);
    }

    @OnClick(R.id.button_final_no)
            public void submit(){
        FinalActivity.this.finish();
    }




    Handler runHangler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String s = textView.getText().toString();
            int number =Integer.valueOf(s);
            if(number > 0){
                number-=1;
            }
            if(number == 0){
                FinalActivity.this.finish();
            }


            textView.setText(String.valueOf(number));
            runHangler.postDelayed(runnable, 1000);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        ButterKnife.bind(this);
        runHangler.postDelayed(runnable, 1000);


        gestureDetector = new GestureDetector(this,new simpleGestureListener());

        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);

        Intent intent1 = getIntent();

        bundle = new Bundle();
        bundle = intent1.getExtras();
        String timer =  bundle.getString("countdown");
        textView.setText(timer);


        //This allows us to pull the data from the intent and store it in our local bundle in this activity
        //getBundle = getIntent().getExtras();
        //The key must match the same key from the sending activity
        //int bundleData2 = getBundle.getInt("imgId");
        //int[] bundleImgId = getBundle.getIntArray("imgIds");
        //Now we set the hint of the view on which we want to see that text appear.
        //bundleImageView1.setImageResource(bundleData2);

        bundleImageView1.setImageResource(Outfit.resId1);
        bundleImageView2.setImageResource(Outfit.resId2);
        bundleImageView3.setImageResource(Outfit.resId3);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // LogUtil.LogD("Gesture","oSingleTapUp");
            Toast.makeText(FinalActivity.this,"SingleTop Up Triggered!",Toast.LENGTH_SHORT).show();

            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            //LogUtil.LogD("Gesture","onLongPress");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

            //Toast.makeText(FinalActivity.this,"OnScroll Triggered!",Toast.LENGTH_SHORT).show();
            sumX+=distanceX;
            sumY+=distanceY;
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(sumX<0){
                if(Math.abs(sumX)>100) {
                    Toast.makeText(FinalActivity.this,"Swipe Left Triggered!",Toast.LENGTH_SHORT).show();

                    sumX = 0;
                    sumY = 0;
                }
            }
            if(sumX>0){
                if(Math.abs(sumX)>100) {
                    Toast.makeText(FinalActivity.this,"Swipe Right Triggered!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FinalActivity.this, ViewWardrobe.class);
                    startActivity(intent);

                    sumY=0;
                    sumX = 0;
                }
            }

            if(sumY<0){
                if(Math.abs(sumY)>100) {

                    sumX = 0;
                    sumY = 0;
                }
            }
            if(sumY>0){
                if(Math.abs(sumY)>100) {

                    sumX = 0;
                    sumY = 0;
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {

            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {

            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {

            return super.onSingleTapConfirmed(e);
        }

    }





}
