package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class headphones extends AppCompatActivity {
    private TextView headphonesStatusTextView;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headphones);

        headphonesStatusTextView = findViewById(R.id.headphonesStatusTextView);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(headphonesReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(headphonesReceiver);
    }

    private final BroadcastReceiver headphonesReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra("state", -1);
            boolean isConnected = state == 1;

            String headphonesStatus = isConnected ? "Headphones are connected" : "Headphones are not connected";
            headphonesStatusTextView.setText(headphonesStatus);
        }
    };
}
