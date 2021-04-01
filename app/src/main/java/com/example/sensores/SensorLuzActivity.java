package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SensorLuzActivity extends MenuActivity {

    TextView tv;
    SensorManager sm;
    SensorEventListener listener;
    Sensor luz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_luz);

        tv = findViewById(R.id.textView);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        luz = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                tv.setText(""+event.values[0]);
                int grayShade = (int) event.values[0];
                if(grayShade > 255) grayShade = 255;

                tv.setTextColor(Color.rgb(255 - grayShade, 255 - grayShade, 255 - grayShade));
                tv.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                Toast.makeText(SensorLuzActivity.this, "Falha", Toast.LENGTH_SHORT).show();
            }
        };

        sm.registerListener(listener, luz, SensorManager.SENSOR_DELAY_FASTEST);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(listener, luz);
    }


}