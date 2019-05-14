package com.example.darianvereen.myapplication2018;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.darianvereen.myapplication2018.Activity.FinalActivity;
import com.example.darianvereen.myapplication2018.Fragment.MainMenuFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    Bundle bundle;
    MediaPlayer mediaPlayer;


    int resId1 = R.drawable.shirt9;
    int resId2 = R.drawable.pants5;
    int resId3 = R.drawable.shoes4;

    int[] resHolder = {resId1, resId2, resId3};

    MainMenuFragment mainMenuFragment;
    @OnClick(R.id.enter_btn)
    public void submit(View view){
        //Toast.makeText(this, "Enter Clicked", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, mainMenuFragment ).commit();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.andapp);
        mediaPlayer.start();


        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainMenuFragment = new MainMenuFragment();


    }

    public void sendBroadcast(View view){
        Intent i =  new Intent();
        i.setAction("com.example.darianvereen.myapplication2018");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }
}
