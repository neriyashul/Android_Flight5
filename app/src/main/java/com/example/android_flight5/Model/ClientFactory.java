package com.example.android_flight5.Model;

import com.example.android_flight5.Model.Creators.ClientsCreators.MyTcpClientCreator;
import com.example.android_flight5.Model.Creators.modelsCreators.MyModelCreator;
import com.example.android_flight5.Model.Interfaces.IClient;
import com.example.android_flight5.Model.Interfaces.IClientCreator;
import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.Interfaces.IModelCreator;

import java.util.HashMap;
import java.util.Map;

public final class ClientFactory {
    private static Map<String, IClientCreator> ClientsMap = new HashMap<String, IClientCreator>() {{
        put("MyClient", new MyTcpClientCreator());
    }};


    public static IClient getClient(String clientName){
        return ClientsMap.get(clientName).create();
    }

    public static void addCreator(String key, IClientCreator creator){
        ClientsMap.put(key, creator);
    }

}
