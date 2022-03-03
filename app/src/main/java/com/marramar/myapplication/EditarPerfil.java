package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marramar.myapplication.adapter.AvatarAdapter;

import java.util.ArrayList;

public class EditarPerfil extends AppCompatActivity {

    RecyclerView recyclerAvatar;
    ArrayList<Avatar> avatar;
    AvatarAdapter avatarAdapter;
    Button btCambiar;
    EditText etNombre;
    Activity actividad;
    public static Avatar avatarSeleccion=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        btCambiar = findViewById(R.id.btCambiar);
        etNombre = findViewById(R.id.etNombre);

        btCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarJugador();
            }
        });

        recyclerAvatar = findViewById(R.id.rvAvatar);
        recyclerAvatar.setLayoutManager(new GridLayoutManager(this.actividad,3));
        recyclerAvatar.setHasFixedSize(true);
        Integer[] fotoAvatar = {R.drawable.avatar1,R.drawable.avatar9,R.drawable.avatar2,R.drawable.avatar3,R.drawable.avatar4,R.drawable.avatar5,R.drawable.avatar6,R.drawable.avatar7,R.drawable.avatar8};
        Integer[] idFoto = {1,2,3,4,5,6,7,8,9};

        avatar = new ArrayList<>();
        for(int i=0; i<fotoAvatar.length; i++){
            Avatar img = new Avatar(fotoAvatar[i],idFoto[i]);
            avatar.add(img);
        }

        recyclerAvatar.setItemAnimator(new DefaultItemAnimator());

        avatarAdapter = new AvatarAdapter(EditarPerfil.this, avatar);

        recyclerAvatar.setAdapter(avatarAdapter);

        avatarSeleccion = avatar.get(0);
    }

    public void registrarJugador(){

        if(etNombre.getText().toString()!=null && !etNombre.getText().toString().trim().equals("")){

            int avatarId =  avatarSeleccion.getImagenid();
            String nombre = etNombre.getText().toString();

            String registro = "Nombre: " + etNombre.getText().toString() + "\n";
            registro += "AvatarId: " + avatarSeleccion.getImagenid();

            Toast.makeText(EditarPerfil.this,"Registrar \n" + registro, Toast.LENGTH_LONG).show();

            /*ConexionSQLiteHelper conn = new ConexionSQLiteHelper(actividad, Utilidades.NOMBRE_DB,null,1);

            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_ID, avatarId);
            values.put(Utilidades.CAMPO_AVATAR, nombre);

            Long idResultante = db.insert(Utilidades.TABLA_PERFIL,Utilidades.CAMPO_ID, values);

            if (idResultante != -1){
                Toast.makeText(EditarPerfil.this,"Registrar \n"+ idResultante + " - " + registro, Toast.LENGTH_LONG).show();
                etNombre.setText("");
            }else{
                Toast.makeText(EditarPerfil.this,"No se pudo registrar al usuario \n" + registro, Toast.LENGTH_LONG).show();
            }

            db.close();*/

        }else{
            Toast.makeText(this,"Debe rellenar todos los datos", Toast.LENGTH_LONG).show();
        }

    }

}