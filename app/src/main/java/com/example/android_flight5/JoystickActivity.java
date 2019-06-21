package com.example.android_flight5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.ModelFactory;
import com.example.android_flight5.Model.MyModel;
import com.example.android_flight5.Model.MyTcpClient;

public class JoystickActivity extends AppCompatActivity implements JoystickView.JoystickListener {
    IModel model = ModelFactory.getModel("MyModel","MyClient");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick);

        // Get the Intent that started this activity and extract the IModel.
        Intent intent = getIntent();
        String ip = intent.getStringExtra("ip");
        String port = intent.getStringExtra("port");

        //model.connectClient(ip, port);

    }

    @Override
    protected void onDestroy() {
        model.disconnectClient();
        super.onDestroy();
    }


    @Override
    public void onJoystickMoved(float xPercent, float yPercent, int id) {
        if (id == R.id.joystick) {
            Log.d("Joystick", "X percent: " + xPercent + " Y percent: " + yPercent);
        }
    }
}
