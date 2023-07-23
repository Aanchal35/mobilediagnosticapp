package com.example.mdt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class charging extends AppCompatActivity {

    private TextView cableStatusTextView;
    private BroadcastReceiver powerConnectionReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charging);

        cableStatusTextView = findViewById(R.id.cableStatusTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerPowerConnectionReceiver();
        updateCableStatus();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterPowerConnectionReceiver();
    }

    private void registerPowerConnectionReceiver() {
        powerConnectionReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action != null) {
                    if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
                        cableStatusTextView.setText("Cable is connected");
                    } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
                        cableStatusTextView.setText("Cable is not connected");
                    }
                }
            }
        };

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(powerConnectionReceiver, filter);
    }

    private void unregisterPowerConnectionReceiver() {
        if (powerConnectionReceiver != null) {
            unregisterReceiver(powerConnectionReceiver);
            powerConnectionReceiver = null;
        }
    }

    private void updateCableStatus() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, filter);
        if (batteryStatus != null) {
            int chargingStatus = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = chargingStatus == BatteryManager.BATTERY_STATUS_CHARGING ||
                    chargingStatus == BatteryManager.BATTERY_STATUS_FULL;
            if (isCharging) {
                cableStatusTextView.setText("Cable is connected");
            } else {
                cableStatusTextView.setText("Cable is not connected");
            }
        }
    }
}
