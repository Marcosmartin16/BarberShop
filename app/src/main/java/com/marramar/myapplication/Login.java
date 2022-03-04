package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.marramar.myapplication.SQL.SQLite;
import com.marramar.myapplication.SQL.BaseDatosUsuarios;

public class Login extends AppCompatActivity {

    EditText etCorreo, etContraseña;
    Button btEntrar, btSign;
    ImageButton btActivar,btDesactivar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SQLite dbHelper = new SQLite(this);

        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        btEntrar = findViewById(R.id.btEntrar);
        btSign = findViewById(R.id.sign_up);

        btSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Sign_up.class);
                startActivity(intent);
            }
        });

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = etCorreo.getText().toString();
                String pass = etContraseña.getText().toString();

                BaseDatosUsuarios dbUsuarios = new BaseDatosUsuarios(Login.this);

                Cursor cursor = dbUsuarios.consultaUsuario(mail, pass);
                if (cursor.getCount() > 0) {

                    Toast.makeText(Login.this, "Login correcto", android.widget.Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Login.this, MainActivity.class);

                    startActivity(intent);
                    vaciar();
                    Login.this.finish();
                } else {
                    Toast.makeText(Login.this, "No se pudo logear", android.widget.Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void vaciar() {

        etCorreo.setText("");
        etContraseña.setText("");
    }
}