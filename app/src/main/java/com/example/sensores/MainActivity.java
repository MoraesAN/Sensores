package com.example.sensores;

import androidx.annotation.NonNull;
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

public class MainActivity extends MenuActivity implements SensorEventListener {

    private Sensor proximidade;
    private TextView resposta;
    private SensorManager medir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medir = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        proximidade = medir.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        resposta = findViewById(R.id.resposta);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.values[0] == 0){
            getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
            resposta.setText("Com proximidade");
        } else {
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            resposta.setText("Sem proximidade "+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Toast.makeText(this, "Mudança de precisão", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        medir.unregisterListener(this, proximidade);
        super.onPause();
    }

    @Override
    protected void onResume() {
        medir.registerListener(this, proximidade, SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }

}