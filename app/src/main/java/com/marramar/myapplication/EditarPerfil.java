package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.marramar.myapplication.adapter.AvatarAdapter;

import java.util.ArrayList;

public class EditarPerfil extends AppCompatActivity {

    RecyclerView recyclerAvatar;
    ArrayList<Avatar> avatar;
    AvatarAdapter avatarAdapter;
    Button guardar;
    Activity actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        recyclerAvatar = findViewById(R.id.rvAvatar);
        recyclerAvatar.setLayoutManager(new GridLayoutManager(this.actividad,3));
        recyclerAvatar.setHasFixedSize(true);
        Integer[] fotoAvatar = {R.drawable.avatar1,R.drawable.avatar9,R.drawable.avatar2,R.drawable.avatar3,R.drawable.avatar4,R.drawable.avatar5,R.drawable.avatar6,R.drawable.avatar7,R.drawable.avatar8};

        avatar = new ArrayList<>();
        for(int i=0; i<fotoAvatar.length; i++){
            Avatar img = new Avatar(fotoAvatar[i]);
            avatar.add(img);
        }

        recyclerAvatar.setItemAnimator(new DefaultItemAnimator());

        avatarAdapter = new AvatarAdapter(EditarPerfil.this, avatar);

        recyclerAvatar.setAdapter(avatarAdapter);
    }


}