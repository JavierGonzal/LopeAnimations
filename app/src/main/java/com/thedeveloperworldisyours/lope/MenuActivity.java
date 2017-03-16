package com.thedeveloperworldisyours.lope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.thedeveloperworldisyours.lope.animationtransition.MenuAnimationTransitionActivity;
import com.thedeveloperworldisyours.lope.transition.ElementStartActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
    }

    public void goToAnimation(View view) {
        Intent intent = new Intent(this, MenuAnimationActivity.class);
        startActivity(intent);
    }

    public void goToTransitions(View view) {
        Intent intent = new Intent(this, MenuTransitionActivity.class);
        startActivity(intent);
    }

    public void goToAnimationAndTransitions(View view) {
        Intent intent = new Intent(this, MenuAnimationTransitionActivity.class);
        startActivity(intent);
    }
}
