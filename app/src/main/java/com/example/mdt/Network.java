package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class Network extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);


        // Find the TextView in the layout
        TextView textView = findViewById(R.id.textView3);

        // Check network connectivity
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnected();

        // Set the text of the TextView to display the network connectivity status
        String networkInfoString = isConnected ? "Network is connected" : "Network is not connected";
        textView.setText(networkInfoString);
    }
}
