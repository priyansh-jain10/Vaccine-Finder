package com.example.vaccine_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView backgroundImage;
    private Animation slideamiations;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundImage=findViewById(R.id.vaccineimg);
        relativeLayout=findViewById(R.id.splashrellayout);
        slideamiations = AnimationUtils.loadAnimation(this, R.anim.logo_slide);
        relativeLayout.startAnimation(slideamiations);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        },3001  );

    }
}
