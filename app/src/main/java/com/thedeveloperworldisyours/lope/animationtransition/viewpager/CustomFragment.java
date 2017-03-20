package com.thedeveloperworldisyours.lope.animationtransition.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thedeveloperworldisyours.lope.R;

public class CustomFragment extends Fragment {

    public static Fragment newInstance(Activity context, int position, float scale) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putFloat("scale", scale);
        return Fragment.instantiate(context, CustomFragment.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout linearLayout = (LinearLayout)
                inflater.inflate(R.layout.view_pager_item, container, false);

        int position = this.getArguments().getInt("position");
        TextView textView = (TextView) linearLayout.findViewById(R.id.view_pager_item_text);
        textView.setText(String.valueOf(position));

        CustomLinearLayout root = (CustomLinearLayout) linearLayout.findViewById(R.id.view_pager_item_root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return linearLayout;
    }
}
