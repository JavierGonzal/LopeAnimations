package com.thedeveloperworldisyours.lope.animationtransition.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedeveloperworldisyours.lope.R;

public class FirstViewPagerFragment extends Fragment {

    public FirstViewPagerFragment() {
        // Required empty public constructor
    }

    public static FirstViewPagerFragment newInstance() {
        return new FirstViewPagerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_pager_first_fragment, container, false);
    }

}
