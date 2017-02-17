package com.thedeveloperworldisyours.lope.transition;

/**
 * Created by javierg on 16/02/2017.
 */

public class VerticalData {
    private String mTitle;
    private int mImage;

    VerticalData(String title, int image){
        mTitle = title;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }
}