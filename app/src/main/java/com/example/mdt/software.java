package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class software extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);

        // Find the TextView in the layout
        TextView textView = findViewById(R.id.textView2);

        // Get the SDK version of the Android software
        int sdkVersion = Build.VERSION.SDK_INT;

        // Get the release version of the Android software
        String releaseVersion = Build.VERSION.RELEASE;

        // Set the text of the TextView to display the software information
        String softwareInfo = "Android SDK Version: " + sdkVersion + "\n" +
                "Android Release Version: " + releaseVersion;
        textView.setText(softwareInfo);
    }
}
