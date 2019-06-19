package com.example.android_flight5.Model.Interfaces;

import java.io.IOException;

public interface IClient {
    void connect(String ip, int port) throws IOException;
    void disconnect() throws IOException;
    void send(String msg) throws IOException;
}
