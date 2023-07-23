package com.example.mdt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Vibration extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;
    private Sensor magnetometer;
    private TextView accelerometerData;
    private TextView gyroscopeData;
    private TextView magnetometerData;
    private PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        accelerometerData = findViewById(R.id.accelerometer_data);
        gyroscopeData = findViewById(R.id.gyroscope_data);
        magnetometerData = findViewById(R.id.magnetometer_data);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Vibration:WakeLock");
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        wakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        wakeLock.release();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor == accelerometer) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            accelerometerData.setText("Accelerometer Data:\nX: " + x + "\nY: " + y + "\nZ: " + z);
        } else if (event.sensor == gyroscope) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            gyroscopeData.setText("Gyroscope Data:\nX: " + x + "\nY: " + y + "\nZ: " + z);
        } else if (event.sensor == magnetometer) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            magnetometerData.setText("Magnetometer Data:\nX: " + x + "\nY: " + y + "\nZ: " + z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing for now
    }
}
