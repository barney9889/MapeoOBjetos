package org.example.java.jdbc.Interfaces;

import org.example.java.jdbc.Objetos.Producto;
import org.example.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosFuncionalidad implements Metodos<Producto> {

    public Connection getConection() throws SQLException {
        return ConexionBaseDatos.getConexionJDBC();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        ArrayList<Producto> listarProductosBBDD = new ArrayList<>();
        ResultSet resultado = getConsultaProductos();
        while (resultado.next()) {

            Producto producto1 = getProducto(resultado);
            listarProductosBBDD.add(producto1);
        }
        return listarProductosBBDD;
    }

    @Override
    public Producto buscarID(Long id) throws SQLException {
        Producto producto = new Producto();

        List<Producto> arrayList = listar();
        for (Producto puntero : arrayList) {
            if (puntero.getId() == id) {
                extracted(producto, puntero);
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String insertSql = "";
        PreparedStatement consulta = null;

        if (producto.getId() == null) {
            insertSql = "insert into productos(nombre,descripcion,precio) VALUES(?,?,?)";
            consulta = getConection().prepareStatement(insertSql);
            consulta.setString(1, producto.getNombre());
            consulta.setString(2, producto.getDescripccion());
            consulta.setString(3, Integer.toString(producto.getPrecio()));
        }
        if (producto.getId() != null && producto.getId() > 0) {
            insertSql = "UPDATE productos SET id=?, nombre=?, descripcion=?, precio=? WHERE id=?";
            consulta = getConection().prepareStatement(insertSql);
            consulta.setInt(1, producto.getId().intValue()); // Establecer el ID en el primer parámetro
            consulta.setString(2, producto.getNombre());
            consulta.setString(3, producto.getDescripccion());
            consulta.setInt(4, producto.getPrecio());
            consulta.setInt(5, producto.getId().intValue());

        }


        consulta.executeUpdate();


    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement consulta = getConection().prepareStatement("DELETE FROM productos where id=? ")) {
            consulta.setLong(1, id);
            consulta.executeUpdate();
        }

    }

    private ResultSet getConsultaProductos() throws SQLException {
        Connection connection = getConection();
        Statement consulta = connection.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from productos");
        return resultado;
    }

    private static Producto getProducto(ResultSet resultado) throws SQLException {
        Producto producto1 = new Producto();
        producto1.setId(resultado.getLong(1));
        producto1.setNombre(resultado.getString(2));
        producto1.setDescripccion(resultado.getString(3));
        producto1.setPrecio(resultado.getInt(4));
        return producto1;
    }

    private static void extracted(Producto producto, Producto puntero) {
        producto.setId(producto.getId());
        producto.setNombre(puntero.getNombre());
        producto.setDescripccion(puntero.getDescripccion());
        producto.setPrecio(puntero.getPrecio());
    }


}
