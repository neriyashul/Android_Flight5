package com.example.android_flight5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_flight5.JoystickView;
import com.example.android_flight5.Model.Interfaces.IModel;
import com.example.android_flight5.Model.MyModel;
import com.example.android_flight5.Model.MyTcpClient;
import com.example.android_flight5.databinding.ActivityMainBinding;

import com.example.android_flight5.view_model.InitViewModel;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        InitViewModel vm = new InitViewModel();
        binding.setViewModel(vm);
    }
}
