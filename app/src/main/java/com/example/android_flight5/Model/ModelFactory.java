package com.example.android_flight5.Model;


import com.example.android_flight5.Model.Creators.modelsCreators.MyModelCreator;
import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.Interfaces.IModelCreator;

import java.util.HashMap;
import java.util.Map;

public final class ModelFactory {
    private static Map<String, IModelCreator> modelsMap = new HashMap<String, IModelCreator>() {{
        put("MyModel", new MyModelCreator());
    }};

    public static IModel getModel(String modelName, String clientName){
        return modelsMap.get(modelName).create(ClientFactory.getClient(clientName));
    }

    public static void addCreator(String key, IModelCreator creator){
        modelsMap.put(key, creator);
    }
}
