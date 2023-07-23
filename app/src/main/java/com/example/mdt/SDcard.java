package com.example.mdt;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.File;

public class SDcard extends AppCompatActivity {

    private TextView mSdCardPathTextView;
    private TextView mSdCardStatusTextView;
    private TextView mSdCardSizeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);

        mSdCardPathTextView = findViewById(R.id.mSdCardInfoTextView);
        mSdCardStatusTextView = findViewById(R.id.mSdCardStatusTextView);
        mSdCardSizeTextView = findViewById(R.id.mSdCardSizeTextView);

        if (isSDCardPresent()) {
            String sdCardPath = getSDCardPath();
            String sdCardStatus = getSDCardStatus();
            String sdCardSize = getSDCardSize();

            mSdCardPathTextView.setText("SD Card Path: " + sdCardPath);
            mSdCardStatusTextView.setText("SD Card Status: " + sdCardStatus);
            mSdCardSizeTextView.setText("SD Card Size: " + sdCardSize);
        } else {
            mSdCardPathTextView.setText("SD Card not found!");
        }
    }

    public static boolean isSDCardPresent() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getSDCardStatus() {
        return Environment.getExternalStorageState();
    }

    public static String getSDCardSize() {
        String sdCardSize = "";
        if (isSDCardPresent()) {
            File path = Environment.getExternalStorageDirectory();
            android.os.StatFs stat = new android.os.StatFs(path.getPath());
            long blockSize = stat.getBlockSizeLong();
            long totalBlocks = stat.getBlockCountLong();
            sdCardSize = formatSize(totalBlocks * blockSize);
        }
        return sdCardSize;
    }

    private static String formatSize(long size) {
        String suffix = null;

        if (size >= 1024) {
            suffix = "KB";
            size /= 1024;
            if (size >= 1024) {
                suffix = "MB";
                size /= 1024;
            }
        }

        StringBuilder resultBuffer = new StringBuilder(Long.toString(size));

        int commaOffset = resultBuffer.length() - 3;
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',');
            commaOffset -= 3;
        }

        if (suffix != null) {
            resultBuffer.append(suffix);
        }
        return resultBuffer.toString();
    }
}

