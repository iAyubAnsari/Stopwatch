package com.ayubansari.stopwatch;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int miliSeconds=10250;
    private boolean running;

    TextView showTimer;
    Button startButton,stopButton,resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTimer=(TextView)findViewById(R.id.textTimer);
        startButton=(Button)findViewById(R.id.buttonStart);
        stopButton=(Button)findViewById(R.id.stopButton);
        resetButton=(Button)findViewById(R.id.resetButton);

        runTimer();

    }
    public void onClickStart(View view){

        running=true;
        startButton.setEnabled(false);


    }
    public void onClickPause(View view){
        running=false;
        startButton.setText("Resume");
        startButton.setEnabled(true);


    }
    public void onClickReset(View view){
        running=false;
        miliSeconds=0;
        startButton.setText("Start");
        startButton.setEnabled(true);

    }
    public void runTimer(){
       final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int miliSecs=miliSeconds%10;
                int hours=miliSeconds/36000;
                int minutes=(miliSeconds/600)%60;
                int secs=(miliSeconds/10)%60;




                String time= String.format("%d:%02d:%02d:%02d",hours,minutes,secs,miliSecs);

                showTimer.setText(time);

                if (running){
                    miliSeconds++;
                }
                handler.postDelayed(this,100);
            }


        });
    }
}
