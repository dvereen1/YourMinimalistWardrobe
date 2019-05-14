package com.example.darianvereen.myapplication2018.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.darianvereen.myapplication2018.Activity.FinalActivity;
import com.example.darianvereen.myapplication2018.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class CustomDialog extends Dialog {
Context context;
    //Define the variable of the listener
    private CustomDialogEventListener listener;

    //Defined Interface: Listener
    public interface CustomDialogEventListener{
      void onClickListener(String msg);
    }

    @OnClick(R.id.dialog_ok)
    public void ok(View view){
        ///Transfer to next fragment...like the pants fragment
        listener.onClickListener("Okay");


        /*Intent menu = new Intent(context, FinalActivity.class);
        context.startActivity(menu);
        ((Activity) context).finish();*/

        dismiss();


    }


    public CustomDialog(@NonNull Context context, CustomDialogEventListener listener) {
        super(context, R.style.dialog);
        //we recieve the listener from the outside
        this.listener = listener;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);


    }
}
