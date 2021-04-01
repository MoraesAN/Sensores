package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_one, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void sensor_luz(MenuItem menuItem){
        Intent intent = new Intent(this, SensorLuzActivity.class);
        startActivity(intent);
    }

    public void sensor_acelerometro(MenuItem menuItem){
        Intent intent = new Intent(this, AcelerometroActivity.class);
        startActivity(intent);
    }

    public void sensor_giroscopio(MenuItem menuItem){
        Intent intent = new Intent(this, GiroscopioActivity.class);
        startActivity(intent);
    }

    public void todos_sensores(MenuItem menuItem){
        Intent intent = new Intent(this, SensoresActivity.class);
        startActivity(intent);
    }

    public void sensor_proximidade(MenuItem menuItem){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}