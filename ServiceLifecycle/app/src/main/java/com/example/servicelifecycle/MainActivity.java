package com.example.servicelifecycle;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5;
    private MyService.SecondsBinder binder;
    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            binder = (MyService.SecondsBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        IntentFilter intentFilter=new IntentFilter("TEN_SECONDS");
        MyReceiver myReceiver=new MyReceiver();
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1://startService
                Intent intent = new Intent();
                intent.setClass(this, MyService.class);
                startService(intent);
                break;
            case R.id.button2://stopService
                intent = new Intent(this, MyService.class);
                stopService(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, MyService.class);
                bindService(intent, sc, BIND_AUTO_CREATE);
                break;
            case R.id.button4:
                unbindService(sc);
                break;
            case R.id.button5:
                if (sc != null && binder != null) {
                    Toast.makeText(this,"Seconds= "+binder.getSeconds(),Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
