package com.thedeveloperworldisyours.lope.common;

import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/**
 * Created by javierg on 16/03/2017.
 */

public class MyScroller extends Scroller {
    public MyScroller(Context context) {
        super(context, new DecelerateInterpolator());
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, 1000 /*1 secs*/);
    }
}
