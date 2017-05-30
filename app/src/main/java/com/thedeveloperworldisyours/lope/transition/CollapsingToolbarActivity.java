package com.thedeveloperworldisyours.lope.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.thedeveloperworldisyours.lope.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollapsingToolbarActivity extends AppCompatActivity {

    @BindView(R.id.collapsing_toolbar_title)
    ImageView mImageView;

    @BindView(R.id.collapsing_toolbar_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_activity);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCollapsing();
            }
        });

    }

    public void goToCollapsing() {
        Intent intent = new Intent(this, CollapsingActivity.class);
        String transitionName = getString(R.string.blue_name);
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, mImageView, transitionName);
        startActivity(intent);
    }

}
