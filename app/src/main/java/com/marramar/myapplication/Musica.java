package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Musica extends AppCompatActivity {

    private ImageButton encender;
    private ImageButton apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        encender = findViewById(R.id.btActivar);
        apagar = findViewById(R.id.btDesactivar);

        encender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducir(v);
            }
        });

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parar(v);
            }
        });

    }

    private void reproducir(View v) {
        startService(new Intent(this, Servicio.class));
    }

    private void parar(View v) {
        stopService(new Intent(this, Servicio.class));
    }

}