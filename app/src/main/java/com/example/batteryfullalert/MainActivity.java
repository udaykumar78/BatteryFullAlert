package com.example.batteryfullalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
public int a=0;
    private TextView batteryTxt;

        @Override
        public void onCreate(Bundle b) {
            super.onCreate(b);
            setContentView(R.layout.activity_main);
            batteryTxt = (TextView) this.findViewById(R.id.batteryTxt);
            this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            System.out.println("in mainnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");

        }
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            batteryTxt.setText(String.valueOf(level) + "%");

            System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");

            Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            Ringtone ringtoneSound = RingtoneManager.getRingtone(getApplicationContext(), ringtoneUri);

            System.out.println("dvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
            if(level==100 && status==2 )
            {

                System.out.println("jfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
                System.out.println(status);
                if (ringtoneSound != null && a==0) {
                    a++;
                    ringtoneSound.play();


                }

            }

        }};

}
