package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class battery extends AppCompatActivity {

    TextView infor;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        infor=(TextView) findViewById(R.id.textView4);


        registerReceiver(this.BatteryInfoReciever,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

    }
    BroadcastReceiver BatteryInfoReciever=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            int battery=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            int charging =intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
            int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
            int voltage=intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);
            boolean present=intent.getExtras() .getBoolean(BatteryManager.EXTRA_PRESENT);
            String technology=intent.getExtras() .getString(BatteryManager.EXTRA_TECHNOLOGY);
            int temperature=intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);




            infor.setText(
                    "battery:"+battery+"\n"+
                            "charging:"+charging+"\n"+
                            "status:"+status+"\n"+  "Present:"+present+"\n"+
                            "Technology:"+technology+"\n"+
                            "Temperature:"+(temperature /10 )+"\n"+
                            "Voltage:"+voltage+"\n");
            BroadcastReceiver broadcastReceiverTemperature = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Integer integerTemperatureLevel = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
                    infor.setText(integerTemperatureLevel.toString());
                    if (integerTemperatureLevel > 20) {
                        Ringtone ringtone = null;
                        ringtone.play();
                    }

                }


            };




        }

    };

}



