package com.thedeveloperworldisyours.lope.animationtransition.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.lope.R;

public class SecondViewPagerFragment extends Fragment {

    public SecondViewPagerFragment() {
        // Required empty public constructor
    }

    public static SecondViewPagerFragment newInstance() {
        return new SecondViewPagerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_pager_second_fragment, container, false);
    }

}
