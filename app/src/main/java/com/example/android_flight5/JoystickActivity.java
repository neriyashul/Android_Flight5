package com.example.android_flight5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.ModelFactory;
import com.example.android_flight5.Model.MyModel;
import com.example.android_flight5.Model.MyTcpClient;
import com.example.android_flight5.databinding.ActivityMainBinding;
import com.example.android_flight5.view_model.JoystickViewModel;


public class JoystickActivity extends AppCompatActivity implements JoystickView.JoystickListener {
    IModel model = ModelFactory.getModel("MyModel","MyClient");
    JoystickViewModel vm = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joystick);
        setContentView(R.layout.activity_joystick);
        vm = new JoystickViewModel();
        vm.onCreate(getIntent());
        //binding.setViewModel(vm);
    }

    @Override
    protected void onDestroy() {
        vm.onDestroy();
        super.onDestroy();
    }


    @Override
    public void onJoystickMoved(float xPercent, float yPercent, int id) {
        vm.onJoystickMoved(xPercent, yPercent);
    }
}
