package com.jx372.gugudanfighter.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import com.jx372.gugudanfighter.R;

import org.w3c.dom.Text;

public class TimerTaskTaskActivity extends AppCompatActivity {
    private Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_task_task);

        timer.schedule(new PlayGameTimerTask(), 1000, 1000);
    }

    public class PlayGameTimerTask extends TimerTask {
        private int seconds;

        @Override
        public void run() {
            ++seconds;
            if(seconds>=30){
                timer.cancel();
                finish();
                return;
            }
            runOnUiThread(new Runnable(){ //스레드가 생기는게 아닌 ui가 변경되는 코드를 이 안에다 사용
                @Override
                public void run() {
                    ((TextView)findViewById(R.id.textView)).setText( ( 30 - seconds +"초") );
                }
            });

        }
    }
}
