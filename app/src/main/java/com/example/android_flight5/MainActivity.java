package com.example.android_flight5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.android_flight5.JoystickView;
import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.MyModel;
import com.example.android_flight5.Model.MyTcpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //JoystickView joystick = new JoystickView(this);

    }

    /** Called when the user touches the button */
    public void onClick(View view) {
        String ip = null;
        int port = -1;

        Intent intent = new Intent(this,
                JoystickActivity.class);
        intent.putExtra("ip", ip);
        intent.putExtra("port", port);

        startActivity(intent);
    }



}
