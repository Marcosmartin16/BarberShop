package com.marramar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TipoCorte{

    private int imagenid;
    String nombreCorte;

    public TipoCorte(int imagenid,String nombreCorte){
        this.imagenid = imagenid;
        this.nombreCorte = nombreCorte;
    }

    public int getImagenid(){
        return imagenid;
    }

    public void setImagenid(int imagenid){
        this.imagenid = imagenid;
    }

    public String getNombreCorte(){
        return nombreCorte;
    }

    public void setNombreCorte(String nombreCorte){
        this.nombreCorte = nombreCorte;
    }
}