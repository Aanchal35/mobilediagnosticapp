package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.MediaController;
import android.widget.VideoView;

public class splash extends AppCompatActivity {

    private VideoView videoView;

    // Your Video URL
    int videoUrl = R.raw.video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        videoView = findViewById(R.id.videoView);

        // Uri object to refer the resource from the videoUrl
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videoUrl);

        // sets the resource from the videoUrl to the videoView
        videoView.setVideoURI(uri);

        // creating object of media controller class
        MediaController mediaController = new MediaController(this);

        // sets the anchor view for the videoView
        mediaController.setAnchorView(videoView);

        // sets the media player to the videoView
        mediaController.setMediaPlayer(videoView);

        // sets the media controller to the videoView
        videoView.setMediaController(mediaController);

        // starts the video
        videoView.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome = new Intent(splash.this, MainActivity.class);
                startActivity(iHome);
                finish();
            }
        }, 2000);
    }
}
