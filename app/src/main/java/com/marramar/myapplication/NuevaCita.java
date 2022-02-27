package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.marramar.myapplication.adapter.CitaAdapter;
import com.marramar.myapplication.adapter.TipoCorteAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class NuevaCita extends AppCompatActivity implements View.OnClickListener {

    Button btFecha;
    Button btHora;
    EditText etFecha;
    EditText etHora;
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
        etFecha = findViewById(R.id.etFecha);
        etHora = findViewById(R.id.etHora);
        btFecha.setOnClickListener(this);
        btHora.setOnClickListener(this);


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
}