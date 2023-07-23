package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Touch extends AppCompatActivity implements View.OnTouchListener {

    private TextView mTouchScreenText;
    private boolean mIsTouching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set full screen view
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_touch);

        // Set touch listener on the full screen view
        View fullScreenView = findViewById(android.R.id.content);
        fullScreenView.setOnTouchListener(this);

        mTouchScreenText = findViewById(R.id.mTouchScreenText);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIsTouching = true;
                break;
            case MotionEvent.ACTION_MOVE:
                // do nothing
                break;
            case MotionEvent.ACTION_UP:
                mIsTouching = false;
                break;
        }

        updateTouchScreenText();
        return true;
    }

    private void updateTouchScreenText() {
        if (mIsTouching) {
            mTouchScreenText.setText("Touch Screen: TOUCHING");
        } else {
            mTouchScreenText.setText("Touch Screen: NOT TOUCHING");
        }
    }
}
