package com.marramar.myapplication;

public class Citas {

    private String nombre;
    private String fecha;
    private String hora;
    private int imagenid;

    public Citas(String nombre, String fecha,String hora, int imagenid){
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.imagenid = imagenid;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getHora(){
        return hora;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public int getImagenid(){
        return imagenid;
    }

    public void setImagenid(int imagenid){
        this.imagenid = imagenid;
    }
}
