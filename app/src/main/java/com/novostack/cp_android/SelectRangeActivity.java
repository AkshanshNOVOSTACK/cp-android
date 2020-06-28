package com.novostack.cp_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Locale;

public class SelectRangeActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {
    private MapView mMapView;
    public static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location mLocation;
    private GoogleMap googleMapG;

    private TextView mTextView3, mTextView5, mTextView8, mTextView10;
    private EditText mCurrentLocation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_range);

        mMapView = findViewById(R.id.mapView_main);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        mTextView3 = findViewById(R.id.textView_3km);
        mTextView3.setOnClickListener(this);
        mTextView5 = findViewById(R.id.textView_5km);
        mTextView5.setOnClickListener(this);
        mTextView8 = findViewById(R.id.textView_8km);
        mTextView8.setOnClickListener(this);
        mTextView10 = findViewById(R.id.textView_10km);
        mTextView10.setOnClickListener(this);

        mCurrentLocation = findViewById(R.id.editText_start);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView = findViewById(R.id.mapView_main);
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
        retrieveMyCurrentLocation();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }
        mMapView.onSaveInstanceState(mapViewBundle);
    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    private void retrieveMyCurrentLocation() {
        mFusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                if (task.isSuccessful()) {
                    Location location = task.getResult();
                    mLocation = location;
                    Log.d("iorer89urb", "onComplete: latitude" + mLocation.getLatitude());
                    Log.d("iorer89urb", "onComplete: longitude" + mLocation.getLongitude());
                    googleMapG.addMarker(new MarkerOptions().position(new LatLng(mLocation.getLatitude(), mLocation.getLongitude())).title("I am Here"));
                    googleMapG.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLocation.getLatitude(), mLocation.getLongitude()), 14));

                    // Zoom in, animating the camera.
                    //googleMapG.animateCamera(CameraUpdateFactory.zoomIn());

                    // Zoom out to zoom level 10, animating with a duration of 2 seconds.
                    googleMapG.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

                    try {

                        Geocoder geo = new Geocoder(getApplicationContext(), Locale.getDefault());
                        List<Address> addresses = geo.getFromLocation(mLocation.getLatitude(), mLocation.getLongitude(), 1);
                        if (addresses.isEmpty()) {
                            mCurrentLocation.setText("Waiting for Location");
                        }
                        else {
                            if (addresses.size() > 0) {
                                mCurrentLocation.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
                            }
                        }
                    }catch(Exception e){
                        Log.d("locationException", "onComplete: Exception :  "+ e);
                    }

                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMapG = googleMap;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView_3km:
                changeSelection(view.getId());
                break;
            case R.id.textView_5km:
                changeSelection(view.getId());
                break;
            case R.id.textView_8km:
                changeSelection(view.getId());
                break;
            case R.id.textView_10km:
                changeSelection(view.getId());
                break;
        }
    }

    public void changeSelection(int view) {
        mTextView3.setBackgroundResource(0);mTextView3.setTextColor(getResources().getColor(R.color.colorBlack));
        mTextView5.setBackgroundResource(0);mTextView5.setTextColor(getResources().getColor(R.color.colorBlack));
        mTextView8.setBackgroundResource(0);mTextView8.setTextColor(getResources().getColor(R.color.colorBlack));
        mTextView10.setBackgroundResource(0);mTextView10.setTextColor(getResources().getColor(R.color.colorBlack));

        switch (view) {
            case R.id.textView_3km:
                mTextView3.setBackgroundResource(R.drawable.shape_range_textview);
                mTextView3.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.textView_5km:
                mTextView5.setBackgroundResource(R.drawable.shape_range_textview);
                mTextView5.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.textView_8km:
                mTextView8.setBackgroundResource(R.drawable.shape_range_textview);
                mTextView8.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.textView_10km:
                mTextView10.setBackgroundResource(R.drawable.shape_range_textview);
                mTextView10.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
        }

    }
}
