package com.thedeveloperworldisyours.lope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.thedeveloperworldisyours.lope.R;
import com.thedeveloperworldisyours.lope.animationtransition.recyclerview.InitAnimationRecyclerViewActivity;
import com.thedeveloperworldisyours.lope.animationtransition.viewpager.ViewPagerTransitionActivity;
import com.thedeveloperworldisyours.lope.transition.ElementStartActivity;
import com.thedeveloperworldisyours.lope.transition.VerticalRecyclerViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAnimationTransitionActivity extends AppCompatActivity {
    @BindView(R.id.menu_animation_transition_activity_toolbar)
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_animation_transition_activity);

        ButterKnife.bind(this);

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

    public void goToViewPagerTransition(View view) {
        Intent intent = new Intent(this, ViewPagerTransitionActivity.class);
        startActivity(intent);
    }

    public void gotToInitAnimationRecyclerView(View view) {
        Intent intent = new Intent(this, InitAnimationRecyclerViewActivity.class);
        startActivity(intent);
    }
}

