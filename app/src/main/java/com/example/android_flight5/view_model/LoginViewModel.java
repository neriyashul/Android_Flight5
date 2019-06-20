package com.example.android_flight5.view_model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.android_flight5.JoystickActivity;

public class LoginViewModel {
    public void onClick(View v) {
        // Code here executes on main thread after user presses button
        Log.i("shilo", "button had clicked");

        Context context = v.getContext();

        Intent intent = new Intent(context, JoystickActivity.class);
        //intent.putExtra("productId", productId);
        context.startActivity(intent);
    }
}
