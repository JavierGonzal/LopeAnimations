package com.thedeveloperworldisyours.lope.animationtransition.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


import com.thedeveloperworldisyours.lope.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by javierg on 25/01/2017.
 */

public class InitAnimationRecyclerViewAdapter extends RecyclerView
        .Adapter<InitAnimationRecyclerViewAdapter
        .DataObjectHolder> {

    private Context mContext;
    private ArrayList<AnimationData> mDataset;
    private static InitAnimationRecyclerViewAdapter.MyClickListener sClickListener;
    // Allows to remember the last item shown on screen
    private int lastPosition = -1;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        @BindView(R.id.init_animation_recycler_view_item_title)
        TextView mLabel;
        @BindView(R.id.init_animation_recycler_view_item_subtitle)
        TextView mDateTime;

        DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    void setOnItemClickListener(InitAnimationRecyclerViewAdapter.MyClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    InitAnimationRecyclerViewAdapter(Context context, ArrayList<AnimationData> myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    @Override
    public InitAnimationRecyclerViewAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.init_animation_recycler_view_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(InitAnimationRecyclerViewAdapter.DataObjectHolder holder, int position) {
        holder.mLabel.setText(mDataset.get(position).getmTitle());
        holder.mDateTime.setText(mDataset.get(position).getmSubTitle());

        // Here you apply the animation when the view is bound
        setAnimation(holder.itemView, position);
    }

    void addItem(AnimationData dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    interface MyClickListener {
        void onItemClick(int position, View v);
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.appearance_go_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
