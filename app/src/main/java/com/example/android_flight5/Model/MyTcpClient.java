package com.example.android_flight5.Model;

import com.example.android_flight5.Model.Interfaces.IClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyTcpClient implements IClient {
    private Socket clientSocket;
    @Override
    public void connect(String ip, int port) throws IOException {
        this.clientSocket = new Socket(ip, port);
    }

    @Override
    public void disconnect() throws IOException {
        if (this.clientSocket != null) {
                this.clientSocket.close();
        }
    }

    @Override
    public void send(String msg) throws IOException {
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(msg);
    }


}
