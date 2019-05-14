package com.example.darianvereen.myapplication2018;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broadcast was sent Earlier", Toast.LENGTH_SHORT).show();
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
