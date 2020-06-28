package com.novostack.cp_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

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
import com.novostack.cp_android.Adapters.MyRideAdapterOnClick;
import com.novostack.cp_android.Adapters.MyRidesAdapater;
import com.novostack.cp_android.ModelClasses.MyRides;

import java.util.ArrayList;
import java.util.List;

public class CompanionsFoundActivity extends AppCompatActivity implements OnMapReadyCallback, MyRideAdapterOnClick {
    private MapView mMapView;
    public static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location mLocation;
    private GoogleMap googleMapG;

    private ImageView mColorFilter;

    private RecyclerView mRecyclerView;
    private List<MyRides> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        setContentView(R.layout.activity_companions_found);
        mMapView = findViewById(R.id.mapView_main);

        mFusedLocationProviderClient  = LocationServices.getFusedLocationProviderClient(this);
        retrieveMyCurrentLocation();

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView = findViewById(R.id.mapView_main);
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
        mColorFilter = findViewById(R.id.imageView_colorFilter);
        mColorFilter.setAlpha(200);

        mRecyclerView= findViewById(R.id.recyclerView_result);
        setUpRecyclerView();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMapG  = googleMap;
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
                if(task.isSuccessful()){
                    Location location = task.getResult();
                    mLocation = location;
                    Log.d("iorer89urb", "onComplete: latitude"+ mLocation.getLatitude());
                    Log.d("iorer89urb", "onComplete: longitude"+ mLocation.getLongitude());
                    googleMapG.addMarker(new MarkerOptions().position(new LatLng(mLocation.getLatitude(), mLocation.getLongitude())).title("I am Here"));
                    googleMapG.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLocation.getLatitude(), mLocation.getLongitude()),14));

                    // Zoom in, animating the camera.
                    //googleMapG.animateCamera(CameraUpdateFactory.zoomIn());

                    // Zoom out to zoom level 10, animating with a duration of 2 seconds.
                    googleMapG.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

                }
            }
        });
    }

    private void setUpRecyclerView() {

        dataList.add(new MyRides("Akshansh Gusain", "12/02/2020 8:00 PM", "$ 10.80", "$ 23.4",
                "Indira Gandhi International Airport New Delhi, Delhi 110037",
                "User 2 : Sector 16, Noida, Uttar Pradesh 201301.","D-149, 2nd Floor, Block D, Sector 10, Noida, Uttar Pradesh 201301"," "));
        dataList.add(new MyRides("Akshansh Gusain", "12/02/2020 8:00 PM", "$ 10.80", "$ 23.4",
                "Indira Gandhi International Airport New Delhi, Delhi 110037",
                "User 2 : Sector 16, Noida, Uttar Pradesh 201301.","D-149, 2nd Floor, Block D, Sector 10, Noida, Uttar Pradesh 201301"," "));
        dataList.add(new MyRides("Akshansh Gusain", "12/02/2020 8:00 PM", "$ 10.80", "$ 23.4",
                "Indira Gandhi International Airport New Delhi, Delhi 110037",
                "User 2 : Sector 16, Noida, Uttar Pradesh 201301.","D-149, 2nd Floor, Block D, Sector 10, Noida, Uttar Pradesh 201301"," "));

        MyRidesAdapater adapter = new MyRidesAdapater(this, dataList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void myRidesAdapterClickListner(int position) {

    }
}
