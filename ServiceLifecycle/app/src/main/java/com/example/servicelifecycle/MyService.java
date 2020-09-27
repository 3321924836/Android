package com.example.servicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private final static String TAG = "_MyService";
    private int seconds;
    private boolean isCounting;

    public class SecondsBinder extends Binder {
        public int getSeconds() {
            return seconds;
        }
    }

    private SecondsBinder binder;

    public MyService() {
        seconds = 60;
        isCounting = true;
        binder=new SecondsBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "START SERVICE!!----onCreate()");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isCounting) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds--;
                    if(seconds%10==0){
                        Intent intent=new Intent();
                        intent.setAction("TEN_SECONDS");
                        intent.putExtra("seconds",seconds);
                        sendBroadcast(intent);
                    }
                    if(seconds==0)isCounting=false;
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "START SERVICE!!----onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isCounting=false;
        Log.i(TAG, "STOP SERVICE!!----destroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        Log.i(TAG, "BIND SERVICE!!----onBind()");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        isCounting=false;
        Log.i(TAG, "UNBIND SERVICE!!----onUnBind()");
        return super.onUnbind(intent);
    }
}
