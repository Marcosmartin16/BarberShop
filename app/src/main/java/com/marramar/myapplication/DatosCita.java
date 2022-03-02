package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DatosCita extends AppCompatActivity {

    TextView tvNombre,tvFecha, tvHora, tvTipoCorte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cita);

        tvFecha = findViewById(R.id.tvFecha);
        tvHora = findViewById(R.id.tvHora);
        tvNombre = findViewById(R.id.tvNombre);
        tvTipoCorte = findViewById(R.id.tvTipoCorte);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("Nombre");
        String fecha = extras.getString("Fecha");
        String hora = extras.getString("Hora");
        String tipoCorte = extras.getString("TipoCorte");

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvHora.setText(hora);
        tvTipoCorte.setText(tipoCorte);
    }
}