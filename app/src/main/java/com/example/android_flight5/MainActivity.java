package com.example.android_flight5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
import com.example.android_flight5.view_model.ConnectViewModel;
import com.example.android_flight5.view_model.MainViewModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final MainViewModel vm = new MainViewModel();
        vm.setName("Rocket Flyer");
        vm.setType("IT Company");

        binding.setViewModel(vm);

        binding.btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Value from model class: " +  vm.getMessage(), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Value from Edittext box: ", Toast.LENGTH_LONG).show();

            }
        });
    }

        //JoystickView joystick = new JoystickView(this);


    /** Called when the user touches the button */
    public void onClick(View view) {
        String ip = null;
        int port = -1;

        Intent intent = new Intent(this,
                JoystickActivity.class);
        intent.putExtra("ip", ip);
        intent.putExtra("port", port);

        startActivity(intent);
    }



}
