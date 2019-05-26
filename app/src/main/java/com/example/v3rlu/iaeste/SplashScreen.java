package com.example.v3rlu.iaeste;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    private static  int SPLASH_time=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash_screen);
        setTheme(R.style.FullScreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,IAESTE_login.class);
                startActivity(i);
                finish();;
            }
        },SPLASH_time);
        //Intent intent = new Intent(getApplicationContext(),
        //IAESTE_login.class);
        //startActivity(intent);
        //finish();
    }
}