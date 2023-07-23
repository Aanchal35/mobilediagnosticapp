package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class Mic extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;
    private Button startRecordingButton, stopRecordingButton;
    private String recordFilePath = null;
    private MediaRecorder mediaRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mic);

        startRecordingButton = findViewById(R.id.start_button);
        stopRecordingButton = findViewById(R.id.stop_button);

        // Disable the stop button at the beginning
        stopRecordingButton.setEnabled(false);

        // Request the microphone permission
        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSION_REQUEST_CODE);
        }

        startRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start recording
                startRecording();
            }
        });

        stopRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Stop recording
                stopRecording();
            }
        });
    }

    private void startRecording() {
        // Create a new instance of MediaRecorder
        mediaRecorder = new MediaRecorder();

        // Set the audio source to the microphone
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        // Set the output format to MPEG-4
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);

        // Set the audio encoder to AAC
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

        // Set the output file path
        String recordFileName = "audio_record_" + System.currentTimeMillis() + ".mp4";
        recordFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + recordFileName;
        mediaRecorder.setOutputFile(recordFilePath);

        // Prepare and start recording
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();

            // Enable the stop button
            stopRecordingButton.setEnabled(true);
            startRecordingButton.setEnabled(false);

            Toast.makeText(this, "Recording started", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopRecording() {
        // Stop and release the MediaRecorder
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;

            // Disable the stop button
            stopRecordingButton.setEnabled(false);
            startRecordingButton.setEnabled(true);

            Toast.makeText(this, "Recording stopped", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle microphone permission request result
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Microphone permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Microphone permission denied", Toast.LENGTH_SHORT).show();
                startRecordingButton.setEnabled(false);
            }
        }
    }
}

