package com.example.testproj2;

import java.util.TimerTask;
import android.view.View;
import android.widget.ImageView;

public class setColor extends TimerTask {
    R.color color;

    public setColor(R.color c) {
        this.color = c;
    }

    @Override
    public void run() {
        //ImageView img= (ImageView) findViewById(R.id.flashbox);
        //img.setImageResource(R.color.white);
    }
}
