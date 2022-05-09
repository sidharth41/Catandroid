package com.sid.catandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.sid.catandroid.Battery.t1;

public class Reciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        t1.setText(intent.getIntExtra("level",0)+" %");

    }
}
