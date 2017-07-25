package com.jx372.gugudanfighter.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bit-user on 2017-07-24.
 */

public class Test {
    private static Timer timer = new Timer();

    public static void main(String args[]){

//        for(int i = 0 ; i < 100 ; i++){
//            int r = randomize(1,9);
//            System.out.println(r);
//        }

        timer.schedule(new PlayGameTimerTask(), 1000, 1000);
    }

    public static int randomize(int from , int to){
        int val =  (int)(Math.random() * to) + from;
        return val;
    }

    private static class PlayGameTimerTask extends TimerTask{
    private int seconds;
        @Override
        public void run() {
            ++seconds;
            if(seconds>=5){
                timer.cancel();
                return;
            }
            System.out.println(seconds);
        }
    }
}

