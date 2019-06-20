package com.example.android_flight5.Model;

import com.example.android_flight5.Model.Interfaces.IClient;
import com.example.android_flight5.Model.Interfaces.IModel;

import java.io.IOException;

public class MyModel implements IModel {
    private IClient client;

    public MyModel(){}

    public MyModel(IClient c){
        this.client = c;
    }

    @Override
    public void setClient(IClient c) {
        this.client = c;
    }

    @Override
    final public void connectClient(String ip, int port) {
        try {
            this.client.connect(ip,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    final public void disconnectClient() {
        try {
            this.client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String msg) {
        msg += System.getProperty("line.separator");
        try {
            this.client.send(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
