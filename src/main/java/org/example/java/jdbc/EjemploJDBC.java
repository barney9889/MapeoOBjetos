package org.example.java.jdbc;

import org.example.java.jdbc.Interfaces.ProductosFuncionalidad;
import org.example.java.jdbc.Objetos.Producto;
import org.example.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

import static org.example.java.jdbc.util.ConexionBaseDatos.conexionJDBC;

public class EjemploJDBC {
    public static void main(String[] args) throws SQLException {
        ProductosFuncionalidad productosFuncionalidad = new ProductosFuncionalidad();
        productosFuncionalidad.listar().forEach(puntero -> System.out.println(puntero.getNombre()));
        Long variableMostrar = 8L;

        System.out.println(productosFuncionalidad.buscarID(variableMostrar).getNombre() + " "
                + productosFuncionalidad.buscarID(variableMostrar).getDescripccion() + " "
                + productosFuncionalidad.buscarID(variableMostrar).getPrecio()
                + " " + productosFuncionalidad.buscarID(variableMostrar).getId());

        productosFuncionalidad.eliminar(1L);

        Producto producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("ps9");
        producto1.setPrecio(2000);
        producto1.setDescripccion("play9");
        productosFuncionalidad.guardar(producto1);


    }
}
