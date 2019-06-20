package com.example.android_flight5.Model.Interfaces;

public interface IModel {
    void setClient(IClient c);
    void connectClient(String ip, int port);
    void disconnectClient();
    void send(String msg);
}
