package com.thedeveloperworldisyours.lope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

    public void goToGmail(View view) {
        Intent intent = new Intent(this, GmailActivity.class);
        startActivity(intent);
    }

    public void goToRight(View view) {
        Intent intent = new Intent(this, RightActivity.class);
        startActivity(intent);
    }
}
