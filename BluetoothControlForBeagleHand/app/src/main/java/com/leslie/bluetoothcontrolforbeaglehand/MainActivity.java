package com.leslie.bluetoothcontrolforbeaglehand;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String TAG = "BtForBeagleHand";
    TextView textView;
    BluetoothAdapter adapter;
    ArrayList<BluetoothDevice> Devices = new ArrayList<BluetoothDevice>();

    private void beginDiscovery() {
        if (!adapter.isDiscovering()) {
            adapter.startDiscovery();
        }
    }

    private BroadcastReceiver discoveryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG, "onReceive action=" + action);
            if (action.equals(BluetoothDevice.ACTION_FOUND)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                textView.setText(textView.getText() + "\n" + device.getAddress());
                if (device.getAddress().equals("B8:27:EB:D5:D3:FB")) {
                    device.createBond();
                }
                Devices.add(device);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = BluetoothAdapter.getDefaultAdapter();
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (adapter != null) {
            Toast.makeText(this, "Device supports Bluetooth!", Toast.LENGTH_SHORT).show();
        }
        if (!adapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBtIntent);
        }
        //adapter.enable();//

        IntentFilter discoveryFilter = new IntentFilter();
        discoveryFilter.addAction(BluetoothDevice.ACTION_FOUND);
        registerReceiver(discoveryReceiver, discoveryFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.startDiscovery();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(discoveryReceiver);
    }


}
