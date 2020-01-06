package com.example.roostertimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerTextView;
    Boolean counterActive = false;
    Button btn;
    CountDownTimer countDownTimer;

    public void updateTimer(int secondsLeft) {

        int minutes = (int) secondsLeft/60;
        int seconds = secondsLeft - minutes *60; //num of seconds leftover

        String secondString = Integer.toString(seconds);
        if (seconds<=9) {
            secondString = "0" + secondString;
        }

        timerTextView.setText(Integer.toString(minutes)+":"+secondString);
    }

    public void resetTimer() {

        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setVisibility(View.VISIBLE);
        countDownTimer.cancel();
        btn.setText("go!");
        counterActive = false;

    }

    public void btnPressed(View view) {

        btn = (Button) findViewById(R.id.startStopButton);

        if (counterActive==false) {

            counterActive = true;
            btn.setText("Stop");
            timerSeekBar.setVisibility(View.INVISIBLE);

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    timerTextView.setText("0:00");
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.roostercrow);
                    mplayer.start();
                    resetTimer();
                }
            }.start();
        }
        else {
            resetTimer();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = (TextView) findViewById(R.id.timerTextView);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
