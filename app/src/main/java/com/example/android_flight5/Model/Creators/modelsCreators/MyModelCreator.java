package com.example.android_flight5.Model.Creators.modelsCreators;

import com.example.android_flight5.Model.Interfaces.IClient;
import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.Interfaces.IModelCreator;
import com.example.android_flight5.Model.MyModel;

public class MyModelCreator implements IModelCreator {

    @Override
    public IModel create(IClient client) {
        return new MyModel(client);
    }
}
