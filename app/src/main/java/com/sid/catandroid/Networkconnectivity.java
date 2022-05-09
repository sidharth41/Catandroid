package com.sid.catandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import static com.sid.catandroid.Battery.t3;

public class Networkconnectivity extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false)){
            t3.setText("Network not available");
        }
        else{
            t3.setText("Network available");
        }

    }
}
