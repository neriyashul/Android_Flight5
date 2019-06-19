package com.example.android_flight5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JoystickView joystick = new JoystickView(this);
        setContentView(R.layout.activity_main);


    }

//    @Override
//    public void onJoystickMoved(float xPercent, float yPercent, int id) {
//        if (id == R.id.joystickLeft) {
//            Log.d("Left Joystick", "X percent: " + xPercent + " Y percent: " + yPercent);
//        }
//    }
}
