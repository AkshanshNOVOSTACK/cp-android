package com.novostack.cp_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.novostack.cp_android.ModelClasses.MyRides;

public class MyRidesDetailsActivity extends AppCompatActivity {
    private static final String TAG = "MyRidesDetailsTag";
    private MyRides mMyRideObject;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rides_details);
        mMyRideObject = gson.fromJson(getIntent().getStringExtra("MyRideObj"), MyRides.class);
    }
}
