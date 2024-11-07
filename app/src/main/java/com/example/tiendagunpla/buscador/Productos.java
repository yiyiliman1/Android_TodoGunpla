package com.example.tiendagunpla.buscador;

public class Productos {
    private String modelo;
    private String nombre;
    private int img;

    public Productos(String modelo, int img, String nombre) {
        this.modelo = modelo;
        this.img = img;
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
