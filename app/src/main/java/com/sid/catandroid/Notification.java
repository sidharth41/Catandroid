package com.sid.catandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Notification extends AppCompatActivity {

    EditText notificationmessage;
    Button notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notificationmessage=findViewById(R.id.notificationmessage);
        notify=findViewById(R.id.Notify);

        notify.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
            String message=notificationmessage.getText().toString();
            NotificationCompat.Builder builder= new NotificationCompat.Builder(getApplicationContext(),"100")
                    .setContentText(message)
                    .setSmallIcon(R.drawable.abc)
                    .setContentTitle("Status Notification");

            NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel=new NotificationChannel("100","sample",NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
            manager.notify(0,builder.build());





            }

        });


    }
}