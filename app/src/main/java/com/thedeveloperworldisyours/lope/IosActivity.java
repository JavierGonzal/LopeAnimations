package com.thedeveloperworldisyours.lope;

import android.os.Build;
import android.os.CountDownTimer;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IosActivity extends AppCompatActivity {

    @BindView(R.id.activity_ios)
    PercentRelativeLayout mPercentRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            // Set the status bar to dark-semi-transparentish
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ios_activity);
        overridePendingTransition(R.anim.ios_go_in, R.anim.ios_go_out);

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
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(IosActivity.this, R.color.colorTransparentShadow));
            }

        }.start();
    }

    public void progressShadow(int iterator) {
        switch (iterator) {
            case 1:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(IosActivity.this, R.color.colorTransparentShadow15));
                break;
            case 2:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(IosActivity.this, R.color.colorTransparentShadow25));
                break;
            case 3:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(IosActivity.this, R.color.colorTransparentShadow35));
                break;
            case 4:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(IosActivity.this, R.color.colorTransparentShadow45));
                break;
            case 5:
                mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(IosActivity.this, R.color.colorTransparentShadow));
                break;

        }
    }

    public void back(View view) {
        mPercentRelativeLayout.setBackgroundColor(ContextCompat.getColor(IosActivity.this, android.R.color.transparent));
        finishMyActivity();
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
        finish();
        overridePendingTransition(R.anim.ios_back_in, R.anim.ios_back_out);
    }

}
