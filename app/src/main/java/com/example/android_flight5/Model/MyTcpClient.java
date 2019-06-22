package com.example.android_flight5.Model;

import android.widget.TextView;

import com.example.android_flight5.Model.Interfaces.IClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class MyTcpClient implements IClient {


    boolean stop = false;
    private final Object monitor = new Object();
    String msg = "";

    @Override
    public void connect(String ip, int port) {
        run(ip, port);
    }

    @Override
    public void disconnect() throws IOException {
        synchronized (monitor) {
            monitor.notifyAll();
        }
        stop = true;
    }

    @Override
    public void send(String msg) {
        this.msg = msg;
        synchronized (monitor) {
            monitor.notifyAll();
        }
    }

    private void sendMassage(Socket socket) {
        DataOutputStream outToServer = null;
        try {
            outToServer = new DataOutputStream(socket.getOutputStream());
            outToServer.writeBytes(msg);
            outToServer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run(final String IP, final int port){
        final Thread thread = new Thread() {
            @Override
            public void run() {
                Socket socket = null;
                try {
                    socket = new Socket(IP, port);

                    while (!stop) {
                        try {
                            synchronized (monitor) {
                                monitor.wait();
                                if (!stop) {
                                    sendMassage(socket);
                                }
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                } catch (Exception ignored){

                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        thread.start();
    }

}