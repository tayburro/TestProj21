package com.example.testproj2;

import java.util.Timer;
import java.util.TimerTask;

public class delayBy {
    Timer timer;

    public delayBy(long millis){
        timer = new Timer();
        timer.schedule(new delayTask(), millis);
    }

    class delayTask extends TimerTask{
        public void run(){
            timer.cancel();
        }
    }

}
