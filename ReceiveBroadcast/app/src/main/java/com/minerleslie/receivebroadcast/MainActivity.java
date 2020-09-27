package com.minerleslie.receivebroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    Receiver1 mReceiver1;
    Receiver2 mReceiver2;
    Receiver3 mReceiver3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("MyBroadcast");
                intent.putExtra("msg", "这是一条自定义广播消息");
                sendBroadcast(intent);
            }
        });
        IntentFilter intentFilter = new IntentFilter("MyBroadcast");
        mReceiver1 = new Receiver1();
        mReceiver2 = new Receiver2();
        intentFilter.setPriority(2);
        registerReceiver(mReceiver1, intentFilter);
        intentFilter.setPriority(1);
        registerReceiver(mReceiver2, intentFilter);
        mReceiver3 = new Receiver3();
        intentFilter = new IntentFilter("android.intent.action.BATTERY_LOW");
        registerReceiver(mReceiver3, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver1);
        unregisterReceiver(mReceiver2);
        unregisterReceiver(mReceiver3);
    }
}
