package com.novostack.cp_android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.novostack.cp_android.ModelClasses.MyRides;
import com.novostack.cp_android.R;

import java.util.List;

public class MyRidesAdapater extends RecyclerView.Adapter<MyRidesAdapater.MyRidesViewHolder> {
    private Context mContext;
    private List<MyRides> mDataList;
    private MyRideAdapterOnClick myRideAdapterOnClick;

    public MyRidesAdapater(Context mContext, List<MyRides> mDataList, MyRideAdapterOnClick myRideAdapterOnClick) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.myRideAdapterOnClick = myRideAdapterOnClick;
    }

    @NonNull
    @Override
    public MyRidesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_my_rides, parent,false);
        return new MyRidesViewHolder(view, myRideAdapterOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRidesViewHolder holder, int position) {
              holder.mName.setText(mDataList.get(position).getPartnerName());
        holder.mhalfPrice.setText(mDataList.get(position).getHalfPrice());
        holder.mFullPrice.setText(mDataList.get(position).getFullPrice());
        holder.mTimeStamp.setText(mDataList.get(position).getTimestamp());
        holder.mStartPoint.setText(mDataList.get(position).getStartingPoint());
        holder.mEndPoint1.setText(mDataList.get(position).getEndPoint1());
        holder.mEndPoint2.setText(mDataList.get(position).getEndPoint2());
        //holder.mDisplayPicture.setText(mDataList.get(position).getPartnerName());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class MyRidesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView mDisplayPicture;
        TextView mName, mhalfPrice, mFullPrice, mTimeStamp, mStartPoint, mEndPoint1, mEndPoint2;
           MyRideAdapterOnClick myRideAdapterOnClick;
        public MyRidesViewHolder(@NonNull View view, MyRideAdapterOnClick myRideAdapterOnClick) {
            super(view);
            mDisplayPicture = view.findViewById(R.id.circularImageView_user_image);
            mName = view.findViewById(R.id.textView_name);
            mhalfPrice = view.findViewById(R.id.textView_user2_share);
            mFullPrice = view.findViewById(R.id.textView_total_fair);
            mTimeStamp = view.findViewById(R.id.textView_date);
            mStartPoint = view.findViewById(R.id.textView_start_location);
            mEndPoint1 = view.findViewById(R.id.textView_end_location_user_2);
            mEndPoint2 = view.findViewById(R.id.textView_end_location_user_1);
            this.myRideAdapterOnClick = myRideAdapterOnClick;
           view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                 myRideAdapterOnClick.myRidesAdapterClickListner(getAdapterPosition());
        }
    }
}
