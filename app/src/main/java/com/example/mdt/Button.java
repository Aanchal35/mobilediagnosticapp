package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class Button extends AppCompatActivity {

    private TextView mVolumeUpText;
    private TextView mVolumeDownText;
    private TextView mSideKeyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mVolumeUpText = findViewById(R.id.mVolumeUpText);
        mVolumeDownText = findViewById(R.id.mVolumeDownText);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                mVolumeUpText.setText("Volume Up: PRESSED");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                mVolumeDownText.setText("Volume Down: PRESSED");
                return true;
            case KeyEvent.KEYCODE_POWER:
                mSideKeyText.setText("Side Key: PRESSED");
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                mVolumeUpText.setText("Volume Up: NOT PRESSED");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                mVolumeDownText.setText("Volume Down: NOT PRESSED");
                return true;
            case KeyEvent.KEYCODE_POWER:
                mSideKeyText.setText("Side Key: NOT PRESSED");
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

}