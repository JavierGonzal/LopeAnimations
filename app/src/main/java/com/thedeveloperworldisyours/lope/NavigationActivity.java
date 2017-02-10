package com.thedeveloperworldisyours.lope;

import android.os.CountDownTimer;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity {

    @BindView(R.id.navigation_activity)
    PercentRelativeLayout mPercentRelativeLayout;

    int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);

        overridePendingTransition(R.anim.navigation_go_in, R.anim.navigation_go_out);

        ButterKnife.bind(this);
        countTime();
    }

    public void countTime() {
        new CountDownTimer(700, 700) {

            public void onTick(long millisUntilFinished) {
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, R.color.colorTransparentShadow));
            }

        }.start();
    }

    public void back(View view) {
        mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, android.R.color.transparent));
        finishMyActivity();
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
        finish();
        overridePendingTransition(R.anim.navigation_back_in, R.anim.navigation_back_out);
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
