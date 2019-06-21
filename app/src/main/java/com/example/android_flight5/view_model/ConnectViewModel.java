package com.example.android_flight5.view_model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.android_flight5.JoystickActivity;

public class ConnectViewModel {


    private String ip;
    private int port = -1;
    private String message;


    /** Called when the user touches the button */
        /** Called when the user touches the button */
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), JoystickActivity.class);
        intent.putExtra("ip", ip);
        intent.putExtra("port", port);
        view.getContext().startActivity(intent);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        if (this.port != -1) {
            return Integer.toString(port);
        } else {
            return "";
        }
    }

    public void setPort(String port) {
        try {
            this.port = Integer.parseInt(port);
        } catch (NumberFormatException ignored){}
    }

    public void setPort(int port){
        this.port = port;
    }

    public int getPortAsInt() {
        return port;
    }
}
