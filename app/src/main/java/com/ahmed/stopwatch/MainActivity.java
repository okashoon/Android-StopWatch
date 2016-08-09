package com.ahmed.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.os.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTime();
        //if(savedInstanceState!=null) {
        //    seconds = savedInstanceState.getInt("seconds");
        //    running = savedInstanceState.getBoolean("running");
       // }
    }

    public void onClickStart(View view){
        running = true;

    }

    public void onClickStop(View view){
        running = false;

    }

    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){

        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running", running);

    }

    Handler handler = new Handler();
    public void runTime() {
        handler.post(runnable);
    }
    Runnable runnable= new Runnable(){
        public void run() {


            TextView runView = (TextView) findViewById(R.id.time_view);

            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            int sec = seconds % 60;

            String timeFormatted = String.format("%d : %d : %d", hours, minutes, sec);
            runView.setText(timeFormatted);


            if (running) {
                seconds++;
            }

            handler.postDelayed(runnable,1000);
        }
    };




}
