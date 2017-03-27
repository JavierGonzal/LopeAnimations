package com.thedeveloperworldisyours.lope.animationtransition.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.thedeveloperworldisyours.lope.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerTransitionActivity extends AppCompatActivity {

    @BindView(R.id.view_pager_transition_activity_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.view_pager_transition_activity_view_pager)
    ViewPager mViewPager;

    public final static int PAGES = 5;
    public final static int FIRST_PAGE = 0  ;

    public CustomPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_transition_activity);

        ButterKnife.bind(this);

        mAdapter = new CustomPagerAdapter(this, this.getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(false, mAdapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        mViewPager.setCurrentItem(FIRST_PAGE);

        // Necessary or the mViewPager will only have one extra page to show
        // make this at least however many pages you can see
        mViewPager.setOffscreenPageLimit(3);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed
        mViewPager.setPageMargin(-200);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void back(View view) {
        finishMyActivity();
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
        finish();
        overridePendingTransition(R.anim.gmail_back_in, R.anim.gmail_back_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finishMyActivity();
                break;
        }
        return true;
    }
}
