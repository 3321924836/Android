package com.leslie.batteryreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

class BatteryReceiver extends BroadcastReceiver {
    //Low battery words
    private static final String TEXT_BATTERY_LOW = "电量过低\n请设置节电模式";

    //Good battery words
    private static final String TEXT_BATTERY_OK = "电量充足\n请恢复正常模式";

    TextView textView;

    //Get view object from the main activity
    BatteryReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //Judge the kind of the action, set corresponding words
        String action = intent.getAction();
        switch (action) {
            case Intent.ACTION_BATTERY_LOW:
                textView.setText(TEXT_BATTERY_LOW);
                break;
            case Intent.ACTION_BATTERY_OKAY:
                textView.setText(TEXT_BATTERY_OK);
                break;
        }

        //Words animation
        AlphaAnimation appearAnimation = new AlphaAnimation(0, 1);
        appearAnimation.setDuration(3000);
        textView.startAnimation(appearAnimation);
    }
}