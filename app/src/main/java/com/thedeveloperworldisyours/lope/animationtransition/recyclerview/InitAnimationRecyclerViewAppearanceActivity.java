package com.thedeveloperworldisyours.lope.animationtransition.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.thedeveloperworldisyours.lope.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InitAnimationRecyclerViewAppearanceActivity extends AppCompatActivity {

    @BindView(R.id.init_animation_recycler_view_appearance_activity_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.init_animation_recycler_view_appearance_activity_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_animation_recycler_view_appearance_activity);
        ButterKnife.bind(this);
        getActionBarWithToolbar();

        getRecyclerView();
    }

    public void getRecyclerView() {
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        InitAnimationRecyclerViewAdapter adapter = new InitAnimationRecyclerViewAdapter(this, getDataSet());
        mRecyclerView.setAdapter(adapter);
    }

    public void getActionBarWithToolbar() {

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    private ArrayList<AnimationData> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            AnimationData obj = new AnimationData("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }
}
