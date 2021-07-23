package com.you.Cando;
import android.graphics.drawable.Drawable;
import com.dinuscxj.progressbar.CircleProgressBar;

import com.dinuscxj.progressbar.CircleProgressBar;

public class MyItem {

    private Drawable icon;
    private String name;
    private String contents;
    private int progress;
    private String place;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPlace(){ return place; }

    public void setPlace(String place) {this.place = place;}

}