package com.sid.catandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText message,number;
    Button send,whatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message=findViewById(R.id.message);
        number=findViewById(R.id.number);
        send=findViewById(R.id.send);
        whatsapp=findViewById(R.id.Whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whatsappintent= new Intent(Intent.ACTION_SEND);
                whatsappintent.setType("text/plain");
                whatsappintent.setPackage("com.whatsapp");
                whatsappintent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
                startActivity(whatsappintent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num=number.getText().toString();
                    String msg=message.getText().toString();
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(num,null,msg,null,null);
                    Toast.makeText(MainActivity.this, "Message sent successfully...", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });



    }
}