package com.minerleslie.servicedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mButton1;
    Button mButton2;
    Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.button);
        mButton1.setOnClickListener(this);
        mButton2 = findViewById(R.id.start);
        mButton2.setOnClickListener(this);
        mButton3 = findViewById(R.id.stop);
        mButton3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                /*Vibrator vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
                //Newer methods can be used
                if(vibrator.hasVibrator()){
                    vibrator.vibrate(3000);
                    vibrator.cancel();
                }

                 */

                //query the sim id
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Toast.makeText(this, telephonyManager.getSimSerialNumber(), Toast.LENGTH_LONG);

                break;
            case R.id.start:
                Intent intent=new Intent();
                intent.setClass(this,MyService.class);
                startService(intent);
                break;
            case R.id.stop:
                Intent intent1=new Intent();
                intent1.setClass(this, MyService.class);
                stopService(intent1);
                break;
        }
    }
}
