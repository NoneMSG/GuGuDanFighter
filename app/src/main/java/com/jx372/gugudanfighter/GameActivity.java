package com.jx372.gugudanfighter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private Timer timer = new Timer();

    private final int[] BUTTON_IDS={
            R.id.button_0_0, R.id.button_0_1, R.id.button_0_2,
            R.id.button_1_0, R.id.button_1_1, R.id.button_1_2,
            R.id.button_2_0, R.id.button_2_1, R.id.button_2_2
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timer.schedule(new PlayGameTimerTask(),1000,1000);
        TextView leftOperand = (TextView)findViewById(R.id.textViewLeftOperand);
        TextView rightOperand = (TextView)findViewById(R.id.textViewRightOperand);
        int left = randomize(1,9);
        int right = randomize(1,9);
        System.out.println("----------"+left+":"+right);
        int answer = left*right;
        System.out.println("----------"+answer);
        leftOperand.setText( ((Integer)left).toString() ) ;
        rightOperand.setText( ((Integer)right).toString() );

        for(int i = 0 ; i < BUTTON_IDS.length ; ++i){
            Button btn = (Button)findViewById(BUTTON_IDS[i]);
            btn.setText( ((Integer)randomize(1,100)).toString());
        }
        Button correctAnswerBtn = (Button)findViewById(BUTTON_IDS[randomize(1,9)]);//버튼아이디 찾아오기
        correctAnswerBtn.setText( ((Integer)answer).toString());

        correctAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView scoreView = (TextView)findViewById(R.id.textViewScore);

                scoreView.setText("");
            }
        });
    }
    public int randomize(int from , int to){

        int val =  (int)(Math.random() * to) + from;
        return val;
    }

    public class PlayGameTimerTask extends TimerTask {
        private int seconds ;
        @Override
        public void run() {
            ++seconds;
            if(seconds>=10){
                timer.cancel();
                //finish();
                //startActivity(new Intent(GameActivity.this,ResultActivity.class));
                return;
            }
            runOnUiThread(new Runnable(){
                @Override
                public void run() {
                    ((TextView)findViewById(R.id.textView22)).setText( ( 10 - seconds +"초") );
                }
            });
        }
    }
}
