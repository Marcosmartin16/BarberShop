package com.marramar.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.marramar.myapplication.Avatar;
import com.marramar.myapplication.Citas;
import com.marramar.myapplication.EditarPerfil;
import com.marramar.myapplication.R;

import java.util.ArrayList;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.AvatarViewHolder> {

    private ArrayList<Avatar> avatares;
    private int posicionMarcada;
    private TextView ultimaSeleccion;
    private LayoutInflater inflador;
    public static Avatar avatarSeleccion=null;
    public static int avatarIdSeleccion = 0;

    public AvatarAdapter(Context conntexto, ArrayList<Avatar> avatares){
        this.avatares =  avatares;
        this.inflador = LayoutInflater.from(conntexto);
        posicionMarcada  = -1;
    }

    public AvatarAdapter.AvatarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflador.inflate(R.layout.avatar,parent,false);
        return new AvatarAdapter.AvatarViewHolder(view);
    }

    public void onBindViewHolder(AvatarAdapter.AvatarViewHolder holder , int position){

        Avatar avatar = avatares.get(position);
        holder.idAvatar.setImageResource(avatar.getImagen(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                avatarSeleccion = avatares.get(position);
                avatarIdSeleccion = position +1;
                TextView barra = view.findViewById(R.id.barraSeleccionId);

                if (barra == ultimaSeleccion){
                    posicionMarcada = -1;
                    ultimaSeleccion = null;
                    barra.setBackgroundColor(Color.WHITE);

                }else{
                    if(ultimaSeleccion != null) ultimaSeleccion.setBackgroundColor(Color.WHITE);
                    barra.setBackgroundColor(Color.RED);
                    posicionMarcada = position;
                    ultimaSeleccion = barra;
                }



            }
        });
    }

    public int getItemCount(){
        return avatares.size();
    }

    public class AvatarViewHolder extends RecyclerView.ViewHolder{
        ImageView idAvatar;
        TextView barraSeleccion;

        public AvatarViewHolder(View itemView){
            super(itemView);
            idAvatar =itemView.findViewById(R.id.idAvatar);
            barraSeleccion=itemView.findViewById(R.id.barraSeleccionId);
        }
    }

    public int getElementoSeleccion(){
        return this.posicionMarcada;
    }
}
