package com.example.mdt;

import android.content.Context;
import android.os.Bundle;

import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class face extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private TextView proximityStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);

        // Initialize SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Get the proximity sensor
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximitySensor == null) {
            // Proximity sensor is not available on this device
            // Handle the case accordingly
        }

        // Get reference to the TextView for proximity status
        proximityStatusTextView = findViewById(R.id.proximityStatusTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the sensor listener
        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the sensor listener to save battery
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for this example
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            float distance = event.values[0];
            // Handle proximity changes (near or far)
            if (distance < proximitySensor.getMaximumRange()) {
                // Object is near
                proximityStatusTextView.setText("Proximity Status: Near");
            } else {
                // Object is far
                proximityStatusTextView.setText("Proximity Status: Far");
            }
        }
    }
}
