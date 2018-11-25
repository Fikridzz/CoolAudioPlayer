package com.example.fikridzakwan.coolaudioplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActivity = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final ProgressBar progressBar = (findViewById(R.id.progressBar));

        Thread mythread = new Thread(){
            public void run(){
                try{
                    while(splashActivity && ms < splashTime){
                        if (!paused){
                            ms = ms + 50;
                            sleep(50);
                            progressBar.setProgress((int)ms);
                        }
                    }
                }catch (Exception e) {
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        };
        mythread.start();
    }
}
