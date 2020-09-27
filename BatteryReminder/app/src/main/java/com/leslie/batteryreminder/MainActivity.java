package com.leslie.batteryreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Welcome words
    private static final String TEXT_WELCOME = "欢迎使用电池小管家";

    BatteryReceiver batteryReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set welcome words
        TextView textView = findViewById(R.id.textView);
        textView.setText(TEXT_WELCOME);

        //Register receiver
        batteryReceiver = new BatteryReceiver(textView);
        IntentFilter batteryFilter = new IntentFilter();
        batteryFilter.addAction(Intent.ACTION_BATTERY_LOW);
        batteryFilter.addAction(Intent.ACTION_BATTERY_OKAY);
        registerReceiver(batteryReceiver, batteryFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Unregister receiver
        unregisterReceiver(batteryReceiver);
    }
}
