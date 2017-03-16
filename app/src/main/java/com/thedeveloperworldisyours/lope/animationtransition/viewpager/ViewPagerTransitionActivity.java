package com.thedeveloperworldisyours.lope.animationtransition.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thedeveloperworldisyours.lope.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerTransitionActivity extends AppCompatActivity {

    @BindView(R.id.view_pager_transition_activity_view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_transition_activity);

        ButterKnife.bind(this);

        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), this));
    }
}
