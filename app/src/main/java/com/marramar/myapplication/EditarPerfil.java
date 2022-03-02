package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.marramar.myapplication.adapter.AvatarAdapter;
import com.marramar.myapplication.adapter.CitaAdapter;
import com.marramar.myapplication.adapter.TipoCorteAdapter;

import java.util.ArrayList;

public class EditarPerfil extends AppCompatActivity {

    RecyclerView recyclerAvatar;
    ArrayList<Avatar> avatar;
    AvatarAdapter avatarAdapter;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        recyclerAvatar = findViewById(R.id.rvAvatar);
        Integer[] fotoAvatar = {R.drawable.aaaaaaaaaaaaaaa,R.drawable.aaaaaaaaaaaaaaa,R.drawable.aaaaaaaaaaaaaaa,R.drawable.aaaaaaaaaaaaaaa,R.drawable.aaaaaaaaaaaaaaa};

        avatar = new ArrayList<>();
        for(int i=0; i<fotoAvatar.length; i++){
            Avatar img = new Avatar(fotoAvatar[i]);
            avatar.add(img);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                EditarPerfil.this,LinearLayoutManager.VERTICAL,false);

        recyclerAvatar.setLayoutManager(layoutManager);
        recyclerAvatar.setItemAnimator(new DefaultItemAnimator());

        avatarAdapter = new AvatarAdapter(EditarPerfil.this, avatar);

        recyclerAvatar.setAdapter(avatarAdapter);
    }


}