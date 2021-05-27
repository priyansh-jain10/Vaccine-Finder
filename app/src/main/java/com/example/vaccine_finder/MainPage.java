package com.example.vaccine_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainPage extends AppCompatActivity {
    private EditText editText;
    private String pincode;
    private View view;
    private RelativeLayout relativeLayout;
    private Button nextbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        editText=findViewById(R.id.editText);
        relativeLayout=findViewById(R.id.vaccinelayout);

        nextbutton=findViewById(R.id.nextbutton);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pincode=editText.getText().toString();
                Intent intent=new Intent(MainPage.this,FindVaccine.class);
                intent.putExtra("Pin Code",pincode);
                intent.putExtra("Date",getTimeStamp());
                Log.d("FINDVACCINE","Pincode:"+pincode+"\n"+"Date:"+getTimeStamp());
                startActivity(intent);
            }
        });
    }
    private String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.CANADA);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        return sdf.format(new Date());
    }

    public boolean onTouchEvent(MotionEvent event) {
        float x1=0,y1=0,x2=0,y2=0;
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1=event.getX();
                y1=event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2=event.getX();
                y2=event.getY();
                if(x1>x2){

                }
                break;
        }
        return false;
    }
}
