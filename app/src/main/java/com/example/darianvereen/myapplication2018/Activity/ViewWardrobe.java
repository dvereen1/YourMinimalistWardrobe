package com.example.darianvereen.myapplication2018.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darianvereen.myapplication2018.MainActivity;
import com.example.darianvereen.myapplication2018.R;
import com.example.darianvereen.myapplication2018.dialog.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewWardrobe extends AppCompatActivity {

    private int checkedId;

    @BindView(R.id.radio_radiogroup)
    RadioGroup radioGroup;

    @BindView(R.id.textView3_wardrobe)
    TextView tv;

    @OnClick(R.id.radio_group_btn)
    public void submit(){
        CustomDialog.CustomDialogEventListener listener = new CustomDialog.CustomDialogEventListener() {
            @Override
            public void onClickListener(String msg) {
                //Toast.makeText(ViewWardrobe.this,"FROM ONCLICK LISTENER", Toast.LENGTH_SHORT).show();
            }
        };

        CustomDialog dialog =
                new CustomDialog(ViewWardrobe.this, listener);
        dialog.show();

    }
    @OnClick(R.id.button2_wardrobe)
    public void sub(){
        Intent goToMainActivity = new Intent(ViewWardrobe.this, MainActivity.class);
        goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(goToMainActivity,0);
    }
    private GestureDetector gestureDetector;
    private int sumX =0;
    private int sumY =0;



    @OnClick(R.id.radio_group_btn)
    public void submit(View view){
        switch (checkedId){
            case R.id.radio_rb1:

                Toast.makeText(ViewWardrobe.this,"You Loved This App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_rb2:
                Toast.makeText(ViewWardrobe.this,"You Hated This App", Toast.LENGTH_SHORT).show();
                break;

            default:
                //showToast("You've chosen nothing  ");
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wardrobe);
        ButterKnife.bind(this);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ViewWardrobe.this.checkedId = checkedId;
            }
        });

            Intent intent = getIntent();

    }




}
