package com.sid.catandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Locationpage extends AppCompatActivity implements LocationListener {
    TextView t1, Locationvalues;
    Button get;

    FusedLocationProviderClient fusedLocationProviderClient;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationpage);
        t1 = findViewById(R.id.Locationtext);

        Locationvalues = findViewById(R.id.Locationvalues);
        get = findViewById(R.id.getlocation);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocationvalues();
            }
        });
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        t1.setText("Latitude " + location.getLatitude() + " Longitude " + location.getLongitude());

    }

    public void getLocationvalues() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                Geocoder geocoder=new Geocoder(Locationpage.this,Locale.getDefault());
                try {
                    List<Address> address=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

                    Locationvalues.setText(address.get(0).getLatitude()+" "+address.get(0).getLongitude()+" "+address.get(0).getCountryName());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

    }

}