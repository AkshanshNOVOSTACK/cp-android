package com.novostack.cp_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.novostack.cp_android.Adapters.MyRideAdapterOnClick;
import com.novostack.cp_android.Adapters.ReportUserAdapter;
import com.novostack.cp_android.Adapters.ReportUserOnClick;
import com.novostack.cp_android.ModelClasses.ReportOptions;

import java.util.ArrayList;
import java.util.List;

public class ReportUserActivity extends AppCompatActivity implements ReportUserOnClick {
    private static final String TAG = "ReportUserTag"  ;
    private RecyclerView mRecyclerView;
    private List<ReportOptions> mDataList = new ArrayList<>();
    ReportUserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_user);
        mRecyclerView = findViewById(R.id.recyclerView_report);
        setUpList();
        setUpRecycler();
    }


    private void setUpList() {
        mDataList.add(new ReportOptions("Made me uncomfortable",false));
      mDataList.add(new ReportOptions("Abusive or threatening",false));
       mDataList.add(new ReportOptions("Inappropriate Content",false));
        mDataList.add(new ReportOptions("Spam or Scam",false));
        mDataList.add(new ReportOptions("Stolen Photo",false));
        mDataList.add(new ReportOptions("Others",false));
    }

    private void setUpRecycler() {
         adapter  =  new ReportUserAdapter(this, mDataList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public void onClickListener(int position, ReportOptions mDataList) {
        try {
            this.mDataList.set(position, mDataList);
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.d(TAG, "onItemChangeListener: " + e.getMessage());
        }
    }
}
