package com.marramar.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marramar.myapplication.Avatar;
import com.marramar.myapplication.Citas;
import com.marramar.myapplication.EditarPerfil;
import com.marramar.myapplication.R;

import java.util.ArrayList;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.AvatarViewHolder> {

    ArrayList<Avatar> avatar;

    public AvatarAdapter(EditarPerfil editarPerfil, ArrayList<Avatar> avatar){
        this.avatar =  avatar;
    }

    public AvatarAdapter.AvatarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.avatar,null,false);
        return new AvatarAdapter.AvatarViewHolder(view);
    }

    public void onBindViewHolder(AvatarAdapter.AvatarViewHolder holder , int position){
        holder.foto.setImageResource(avatar.get(position).getImagenid());
    }

    public int getItemCount(){
        return avatar.size();
    }

    public class AvatarViewHolder extends RecyclerView.ViewHolder{
        ImageView foto;

        public AvatarViewHolder(View itemView){
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.imTipo);
        }
    }
}
