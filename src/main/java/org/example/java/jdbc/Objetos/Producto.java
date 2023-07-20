package org.example.java.jdbc.Objetos;

public class Producto {
    private Long id;
    private String nombre;
    private String descripccion;
    private int precio;

    public Producto(){

    }

    public Producto(Long id) {
        this.id = id;
    }

    public Producto(Long id, String nombre, String descripccion, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.precio = precio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
