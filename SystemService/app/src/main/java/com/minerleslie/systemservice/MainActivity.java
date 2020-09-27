package com.minerleslie.systemservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.AlarmClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG_VIBRATION = "Vibrator ";
    private final static String TAG_ALARM = "Alarm ";
    private final static String TAG_CARRIER = "Carrier ";
    Button mButton1;
    Button mButton2;
    Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mButton3 = findViewById(R.id.button3);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                if (vibrator.hasVibrator()) {
                    //VibrationEffect vibrationEffect = VibrationEffect.createOneShot(1000, 1000);
                    vibrator.vibrate(5000);
                    Log.i(TAG_VIBRATION, "Vibrating");
                } else Log.i(TAG_VIBRATION, "Vibrator not found");
                break;
            case R.id.button2:
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                if(alarmManager!=null){
                    PendingIntent pendingIntent= PendingIntent.getBroadcast(this,0,new Intent(),0);
                    alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,1000,pendingIntent);
                    Log.i(TAG_ALARM, "Set alarm");
                }
                break;
            case R.id.button3:
                //TelephonyManager telephonyManager=(TelephonyManager) getSystemService(TELEPHONY_SERVICE);
                //String name=telephonyManager.getSimCarrierIdName().toString();
                //Toast.makeText(this,name,Toast.LENGTH_LONG);
                Log.i(TAG_CARRIER, "中国联通");
                break;
        }
    }
}
