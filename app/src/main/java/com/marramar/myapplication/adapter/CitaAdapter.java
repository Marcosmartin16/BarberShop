package com.marramar.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marramar.myapplication.Citas;
import com.marramar.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.CitaViewHolder> {

    ArrayList<Citas> citas;

    public CitaAdapter(ArrayList<Citas> citas){
        this.citas =  citas;
    }

    public CitaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.citas,null,false);
        return new CitaViewHolder(view);
    }

    public void onBindViewHolder(CitaViewHolder holder , int position){
        holder.txtNombre.setText(citas.get(position).getNombre());
        holder.txtFecha.setText(citas.get(position).getFecha());
        holder.txtHora.setText(citas.get(position).getHora());
        holder.foto.setImageResource(citas.get(position).getImagenid());
    }

    public int getItemCount(){
        return citas.size();
    }

    public class CitaViewHolder extends RecyclerView.ViewHolder{
        TextView txtNombre, txtFecha, txtHora;
        ImageView foto;

        public CitaViewHolder(View itemView){
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            txtFecha = (TextView) itemView.findViewById(R.id.tvFecha);
            txtHora = (TextView) itemView.findViewById(R.id.tvHora);
            foto = (ImageView) itemView.findViewById(R.id.imTipo);
        }
    }
}

