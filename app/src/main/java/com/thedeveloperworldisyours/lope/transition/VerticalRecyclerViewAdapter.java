package com.thedeveloperworldisyours.lope.transition;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thedeveloperworldisyours.lope.R;
import com.thedeveloperworldisyours.lope.common.CropCircleTransformation;

import java.util.ArrayList;

/**
 * Created by javierg on 16/02/2017.
 */

public class VerticalRecyclerViewAdapter extends RecyclerView
        .Adapter<VerticalRecyclerViewAdapter
        .DataObjectHolder> {

    private ArrayList<VerticalData> mDataset;
    private static VerticalRecyclerViewAdapter.MyClickListener sClickListener;
    private Context mContext;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView mLabel;
        ImageView mImage;

        DataObjectHolder(View itemView) {
            super(itemView);
            mLabel = (TextView) itemView.findViewById(R.id.vertical_list_item_title);
            mImage = (ImageView) itemView.findViewById(R.id.vertical_list_item_subtitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    void setOnItemClickListener(VerticalRecyclerViewAdapter.MyClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    VerticalRecyclerViewAdapter(ArrayList<VerticalData> myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public VerticalRecyclerViewAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(VerticalRecyclerViewAdapter.DataObjectHolder holder, int position) {
        holder.mLabel.setText(mDataset.get(position).getTitle());
        Glide.with(mContext)
                .load(mDataset.get(position).getImage())
                .bitmapTransform(new CropCircleTransformation( mContext ))
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    interface MyClickListener {
        void onItemClick(int position, View v);
    }

}
