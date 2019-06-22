package com.example.android_flight5.view_model;

import android.content.Intent;
import android.util.Log;

import com.example.android_flight5.JoystickView;
import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.ModelFactory;
import com.example.android_flight5.Model.MyModel;
import com.example.android_flight5.Model.MyTcpClient;
import com.example.android_flight5.R;

public class JoystickViewModel {
    private IModel model = ModelFactory.getModel("MyModel","MyClient");
    private float aileron;
    private float elevator;
    private String a;

    public void onCreate(Intent intent){
        // Get the Intent that started this activity and extract the IModel.
        String ip = intent.getStringExtra("ip");
        int port = intent.getIntExtra("port", -1);

        if(port != -1) {
            connectClient(ip, port);
        }
    }


    public void onDestroy(){
        // Get the Intent that started this activity and extract the IModel.
        model.disconnectClient();
    }


    private void connectClient(String ip, int port) {
        model.connectClient(ip, port);
    }

    private void sendToServer(String msg) {
        model.send(msg);
    }


    public float getAileron() {
        return aileron;
    }

    public void setAileron(float aileron) {
        this.aileron = aileron;
        sendToServer("set /controls/flight/aileron " + aileron);
    }

    public void setElevator(float elevator) {
        this.elevator = elevator;
        sendToServer("set /controls/flight/elevator "+ elevator);
    }

    public float getElevator() {
        return elevator;
    }

    public String getA() {
        return a;
    }

    public void onJoystickMoved(float x, float y) {
        setAileron(x);
        setElevator(y);
    }
}
