package com.marramar.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.marramar.myapplication.R;
import com.marramar.myapplication.TipoCorte;

import java.util.ArrayList;

public class TipoCorteAdapter extends RecyclerView.Adapter<TipoCorteAdapter.TipoCorteViewHolder> {

    ArrayList<TipoCorte> tipo_corte;
    Context context;

    public TipoCorteAdapter(Context context,ArrayList<TipoCorte> tipo_corte){
        this.context = context;
        this.tipo_corte =  tipo_corte;
    }

    public TipoCorteAdapter.TipoCorteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tipo_corte,null,false);
        return new TipoCorteViewHolder(view);
    }

    public void onBindViewHolder(TipoCorteAdapter.TipoCorteViewHolder holder , int position){
        holder.foto.setImageResource(tipo_corte.get(position).getImagenid());
        holder.textView.setText(tipo_corte.get(position).getNombreCorte());
    }

    public int getItemCount(){
        return tipo_corte.size();
    }

    public class TipoCorteViewHolder extends RecyclerView.ViewHolder{
        ImageView foto;
        TextView textView;

        public TipoCorteViewHolder(View itemView){
            super(itemView);
            foto = itemView.findViewById(R.id.idTipo);
            textView = itemView.findViewById(R.id.idNombre);
        }
    }
}
