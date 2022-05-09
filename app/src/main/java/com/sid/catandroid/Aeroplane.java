package com.sid.catandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

import java.util.Set;

import static com.sid.catandroid.Battery.t2;

public class Aeroplane extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int value=Settings.System.getInt(context.getApplicationContext().getContentResolver(), Settings.Global.AIRPLANE_MODE_ON,0);
        //Toast.makeText(context, ""+value, Toast.LENGTH_SHORT).show();
        if(value==0){
            t2.setText("Aeroplane Mode turned on");
        }
        else{
            t2.setText("Aeroplane Mode turned off");
        }

    }

}
