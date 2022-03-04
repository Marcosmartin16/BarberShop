package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.marramar.myapplication.adapter.CitaAdapter;
import com.marramar.myapplication.adapter.TipoCorteAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class NuevaCita extends AppCompatActivity implements View.OnClickListener {

    Button btFecha, btHora, btConfirmar;
    EditText etNombre,etFecha, etHora, etTipoCorte;
    private int dia,mes, año, hora, minutos;

    RecyclerView recyclerTipoCorte;
    ArrayList<TipoCorte> tipoCortes;
    TipoCorteAdapter tipoCorteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cita);
        
        btFecha = findViewById(R.id.btnFecha);
        btHora = findViewById(R.id.btnHora);
        btConfirmar = findViewById(R.id.btnConfirmar);
        etFecha = findViewById(R.id.etFecha);
        etHora = findViewById(R.id.etHora);
        etNombre = findViewById(R.id.etNombre);
        etTipoCorte = findViewById(R.id.etTipoCorte);

        btFecha.setOnClickListener(this);
        btHora.setOnClickListener(this);


        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Confirmar();
            }
        });



        recyclerTipoCorte = findViewById(R.id.rvTipoCorte);
        Integer[] fotoCortes = {R.drawable.ic_nino,R.drawable.ic_adulto,R.drawable.ic_jubilado,R.drawable.ic_beard,R.drawable.ic_cejas};
        String[] nombreCorte ={"Niño", "Adulto", "Jubilado", "Barba", "Cejas"};


        tipoCortes = new ArrayList<>();
        for(int i=0; i<fotoCortes.length; i++){
            TipoCorte tipo = new TipoCorte(fotoCortes[i],nombreCorte[i]);
            tipoCortes.add(tipo);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                NuevaCita.this,LinearLayoutManager.HORIZONTAL,false
        );

        recyclerTipoCorte.setLayoutManager(layoutManager);
        recyclerTipoCorte.setItemAnimator(new DefaultItemAnimator());

        tipoCorteAdapter = new TipoCorteAdapter(NuevaCita.this, tipoCortes);

        recyclerTipoCorte.setAdapter(tipoCorteAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v == btFecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    etFecha.setText(dayOfMonth + " / " + (month+1) + " / " + year);

                }
            },dia,mes,año);
            datePickerDialog.show();
        }
        if(v == btHora){
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    etHora.setText(hourOfDay + " : " + minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
    }

    public void Confirmar(){
        String nombre = etNombre.getText().toString();
        String fecha = etFecha.getText().toString();
        String hora = etHora.getText().toString();
        String tipoCorte = etTipoCorte.getText().toString();

        if (nombre.equals("") || fecha.equals("") || hora.equals("") || tipoCorte.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Complete todos los campos", Toast.LENGTH_SHORT);
            toast.show();
        } else {

            Intent intent = new Intent(getApplicationContext(), NuevaCita.class);
            intent.putExtra("Nombre", nombre);
            intent.putExtra("Fecha", fecha);
            intent.putExtra("Hora", hora);
            intent.putExtra("TipoCorte", tipoCorte);

            startActivity(intent);
        }
    }
}