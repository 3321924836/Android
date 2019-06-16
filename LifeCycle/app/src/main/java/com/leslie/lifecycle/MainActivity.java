package com.leslie.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String TAG = "myTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "1onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "1onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "1onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "1onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "1onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "1onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "1onDestroy: ");
    }
}
