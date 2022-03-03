package com.marramar.myapplication;

public class Avatar {

    private int imagenid;

    public Avatar(int imagenid){
        this.imagenid = imagenid;
    }

    public int getImagenid(int position){
        return imagenid;
    }

    public void setImagenid(int imagenid){
        this.imagenid = imagenid;
    }

}
