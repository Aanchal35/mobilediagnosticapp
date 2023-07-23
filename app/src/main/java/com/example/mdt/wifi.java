package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class wifi extends AppCompatActivity {
        private WifiManager wifiManager;
        private TextView wifiStatusTextView;
        private Button wifiButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_wifi);

            wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

            wifiStatusTextView = findViewById(R.id.wifiStatusTextView);
            wifiButton = findViewById(R.id.wifiButton);

            wifiButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleWifi();
                }
            });
        }

        @Override
        protected void onResume() {
            super.onResume();
            registerReceiver(wifiStateReceiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
        }

        @Override
        protected void onPause() {
            super.onPause();
            unregisterReceiver(wifiStateReceiver);
        }

        private void toggleWifi() {
            if (wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(false);
            } else {
                wifiManager.setWifiEnabled(true);
            }
        }

        private final BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
                String wifiStatus;

                switch (wifiState) {
                    case WifiManager.WIFI_STATE_ENABLED:
                        wifiStatus = "Wi-Fi is enabled";
                        break;
                    case WifiManager.WIFI_STATE_DISABLED:
                        wifiStatus = "Wi-Fi is disabled";
                        break;
                    default:
                        wifiStatus = "Wi-Fi state unknown";
                        break;
                }

                wifiStatusTextView.setText(wifiStatus);
            }
        };
    }
