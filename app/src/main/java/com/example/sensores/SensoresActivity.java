package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class SensoresActivity extends MenuActivity implements SensorEventListener {

    private TextView txttvSensores;
    private SensorManager sensorManager;
    private List<Sensor> all;
    private static int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);

        sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        all = sensorManager.getSensorList(Sensor.TYPE_ALL);

        txttvSensores = findViewById(R.id.txttvSensores);

       // txttvSensores.setText(all.toString());
        txttvSensores.setText("");
        for (Sensor cada : all ) {
            txttvSensores.setText(txttvSensores.getText().toString()+cada.getName()+" | "+cada.getMaximumRange()+"\n");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}