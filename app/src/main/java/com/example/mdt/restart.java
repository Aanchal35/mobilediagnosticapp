package com.example.mdt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

public class restart extends AppCompatActivity {

    private TextView restartStatusTextView;
    private Button my_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);

        restartStatusTextView = findViewById(R.id.restartStatusTextView);
        my_button = findViewById(R.id.my_button);

        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartPhone();
            }
        });

        // Get the elapsed time since the last reboot in milliseconds
        long uptime = SystemClock.elapsedRealtime();

        // Convert the elapsed time to days
        long daysSinceLastRestart = TimeUnit.DAYS.convert(uptime, TimeUnit.MILLISECONDS);

        // Display the restart status message based on the number of days
        if (daysSinceLastRestart <= 1) {
            restartStatusTextView.setText("Your phone was restarted less than a day ago.");
        } else if (daysSinceLastRestart <= 7) {
            restartStatusTextView.setText("Your phone was restarted " + daysSinceLastRestart + " days ago.");
        } else {
            restartStatusTextView.setText("Your phone has not been restarted for " + daysSinceLastRestart + " days.");
        }

        Log.d("PowerRestart", "Days since last restart: " + daysSinceLastRestart);
    }

    private void restartPhone() {
        // Restart the phone
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        pm.reboot(null);
    }
}

