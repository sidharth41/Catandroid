package com.sid.catandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button msgb,broadcst,noti,locationpage,Googlemappage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        broadcst=findViewById(R.id.Broadcast);
        msgb=findViewById(R.id.messaging);
        locationpage=findViewById(R.id.Location);
        Googlemappage=findViewById(R.id.Googlemappage);

        noti=findViewById(R.id.status_notification);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Notification.class));
            }
        });
        broadcst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Battery.class));
            }
        });
        msgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        locationpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Locationpage.class));
            }
        });
        Googlemappage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Googlemap.class));
            }
        });

    }
}