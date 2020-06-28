package com.novostack.cp_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.novostack.cp_android.Adapters.MyRideAdapterOnClick;
import com.novostack.cp_android.Adapters.MyRidesAdapater;
import com.novostack.cp_android.ModelClasses.MyRides;

import java.util.ArrayList;
import java.util.List;

public class MyRidesActivity extends AppCompatActivity implements MyRideAdapterOnClick {
   private RecyclerView mRecyclerView;
    private List<MyRides> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rides);
        mRecyclerView= findViewById(R.id.recycler_myRides);
        setUpRecyclerView();
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
         sendToDetailsPage(position);
    }

    private void sendToDetailsPage(int position) {
        Gson gson  = new Gson();
        String jsonString = gson.toJson(dataList.get(position));
              Intent p = new Intent(MyRidesActivity.this, MyRidesDetailsActivity.class);
              p.putExtra("MyRideObj", jsonString);
              startActivity(p);
    }


}
