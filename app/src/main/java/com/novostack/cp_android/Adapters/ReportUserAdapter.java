package com.novostack.cp_android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.novostack.cp_android.ModelClasses.ReportOptions;
import com.novostack.cp_android.R;

import java.util.List;

public class ReportUserAdapter extends RecyclerView.Adapter<ReportUserAdapter.ReportViewHolder> {
    private Context mContext;
    private List<ReportOptions> mDataList;
    private ReportUserOnClick reportUserAdapter;

    public ReportUserAdapter(Context mContext, List<ReportOptions> mDataList, ReportUserOnClick reportUserAdapter) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.reportUserAdapter = reportUserAdapter;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_report_user,parent, false);
        return new ReportViewHolder(view, reportUserAdapter);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {

        ReportOptions model = mDataList.get(position);

        if(model!=null){
               holder.textView.setText(model.getTitle());
               holder.i = position;

               if(model.isSelected()){
                      holder.mTick.setImageResource(R.drawable.ic_ticked_square);
               }else{
                   holder.mTick.setImageResource(R.drawable.ic_unticked_square);

            }
        }

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
               TextView textView;
               ImageView mTick;
               ReportUserOnClick reportUserOnClick;
               int i;

         ReportViewHolder(@NonNull View itemView, ReportUserOnClick reportUserOnClick) {
            super(itemView);
             textView = itemView.findViewById(R.id.textView_option_text);
             mTick = itemView.findViewById(R.id.imageView_tick);
             this.reportUserOnClick = reportUserOnClick;
             itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
             ReportOptions model = mDataList.get(getAdapterPosition());
                    if(model.isSelected()){
                         model.setSelected(false);
                    }else{
                         model.setSelected(true);
                    }
                    mDataList.set(getAdapterPosition(), model);
                   reportUserOnClick.onClickListener(getAdapterPosition(), model);

        }
    }
}
