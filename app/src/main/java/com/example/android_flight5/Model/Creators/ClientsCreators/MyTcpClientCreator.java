package com.example.android_flight5.Model.Creators.ClientsCreators;

import com.example.android_flight5.Model.Interfaces.IClient;
import com.example.android_flight5.Model.Interfaces.IClientCreator;
import com.example.android_flight5.Model.MyTcpClient;

public class MyTcpClientCreator implements IClientCreator {
    @Override
    public IClient create() {
        return new MyTcpClient();
    }
}
