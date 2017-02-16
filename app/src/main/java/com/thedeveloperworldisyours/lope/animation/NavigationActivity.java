package com.thedeveloperworldisyours.lope.animation;

import android.os.CountDownTimer;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.thedeveloperworldisyours.lope.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity {

    @BindView(R.id.navigation_activity)
    PercentRelativeLayout mPercentRelativeLayout;

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
                timerShadow();
            }

        }.start();
    }

    public void timerShadow() {
        new CountDownTimer(200, 40) {
            int total = 0;

            public void onTick(long millisUntilFinished) {
                //here you can have your logic to set text to edittext
                total = total + 1;
                progressShadow(total);
            }

            public void onFinish() {
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, R.color.colorTransparentShadow));
            }

        }.start();
    }

    public void progressShadow(int iterator) {
        switch (iterator) {
            case 1:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, R.color.colorTransparentShadow15));
                break;
            case 2:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, R.color.colorTransparentShadow25));
                break;
            case 3:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, R.color.colorTransparentShadow35));
                break;
            case 4:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, R.color.colorTransparentShadow45));
                break;
            case 5:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, R.color.colorTransparentShadow));
                break;

        }
    }

    public void back(View view) {
        finishMyActivity();
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
//        timerShadowOpposed();
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(NavigationActivity.this, android.R.color.transparent));
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
