package com.thedeveloperworldisyours.lope.animationtransition.viewpager;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.thedeveloperworldisyours.lope.common.MyScroller;

import java.lang.reflect.Field;

/**
 * Created by javierg on 16/03/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;
    private Activity mActivity;

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    public ViewPagerAdapter(FragmentManager supportFragmentManager, Activity activity) {
        super(supportFragmentManager);
        mActivity = activity;
        setMyScroller();
    }

    private void setMyScroller() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new MyScroller(mActivity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FirstViewPagerFragment();

            case 1:
                return new SecondViewPagerFragment();

            case 2:
                return new ThirdViewPagerFragment();

            default:
                return null;
        }
    }

}
