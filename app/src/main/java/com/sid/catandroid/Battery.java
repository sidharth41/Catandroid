package com.sid.catandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Battery extends AppCompatActivity {

   public static TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        t1=findViewById(R.id.batterylevel);
        t2=findViewById(R.id.aeroplane);
        t3=findViewById(R.id.Connectivity);
        Reciever reciever=new Reciever();
        Aeroplane aeroplane=new Aeroplane();
        Networkconnectivity nc=new Networkconnectivity();

        registerReceiver(reciever,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        registerReceiver(aeroplane,new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        registerReceiver(nc,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


    }
}