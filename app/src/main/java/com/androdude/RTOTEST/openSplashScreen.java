package com.androdude.RTOTEST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class openSplashScreen extends AppCompatActivity {
    private ImageView icon,Dev;
    final Handler handler = new Handler();

    private ImageView logo,Dev1;
    private Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_splash_screen);

        logo = (ImageView)findViewById(R.id.icon1);
        Dev1 = (ImageView)findViewById(R.id.dev);

        logo.setAlpha(0f);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.animate().alpha(100f).translationYBy(-900f).setDuration(1200);
            }
        },500);



        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(getApplicationContext(), menuitems.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slidein, R.anim.slideout);
            }
        },3000);




    }
}
