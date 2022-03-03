package com.marramar.myapplication;

public class Avatar {

    private int imagenid;
    private int imagen;

    public Avatar(int imagen, int imagenid){
        this.imagenid = imagenid;
        this.imagen = imagen;
    }

    public int getImagenid() { return imagenid;}

    public void setImagenid(int imagenid){
        this.imagenid = imagenid;
    }

    public int getImagen(int position){
        return imagen;
    }

    public void setImagen(int imagen){
        this.imagen = imagen;
    }


}
