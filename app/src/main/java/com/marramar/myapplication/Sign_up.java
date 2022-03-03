package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marramar.myapplication.SQL.AdminSQLite;
import com.marramar.myapplication.SQL.BaseDatosUsuarios;

public class Sign_up extends AppCompatActivity {

    EditText etNombre, etCorreo, etContraseña;
    Button btCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        AdminSQLite dbHelper = new AdminSQLite(this);

        btCrear = findViewById(R.id.btCrear);
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);

        btCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = etNombre.getText().toString();
                String mail = etCorreo.getText().toString();
                String pass = etContraseña.getText().toString();

                BaseDatosUsuarios dbUsuarios = new BaseDatosUsuarios(Sign_up.this);

                long id = dbUsuarios.insertarUsuario(user,mail,pass);

                if((id > 0)){
                    Toast.makeText(Sign_up.this,"Registro completado", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Sign_up.this, MainActivity.class);

                    startActivity(intent);
                    vaciar();
                    Sign_up.this.finish();
                }else{
                    Toast.makeText(Sign_up.this,"Error en el Registro", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void vaciar() {

        etNombre.setText("");
        etCorreo.setText("");
        etContraseña.setText("");
    }
}