package com.thedeveloperworldisyours.lope.animationtransition.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.thedeveloperworldisyours.lope.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InitAnimationRecyclerViewActivity extends AppCompatActivity {


    @BindView(R.id.init_animation_recycler_view_activity_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_animation_recycler_view_activity);
        overridePendingTransition(R.anim.appearance_go_in, R.anim.appearance_go_out);

        ButterKnife.bind(this);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void appearance(View view) {
        startActivity(new Intent(this, InitAnimationRecyclerViewAppearanceActivity.class));
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
        finish();
        overridePendingTransition(R.anim.appearance_back_in, R.anim.appearance_back_out);
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
