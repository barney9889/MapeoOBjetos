package org.example.java.jdbc.Interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Metodos<T> {
    List<T> listar() throws SQLException;

    T buscarID(Long id) throws SQLException;

    void guardar(T t) throws SQLException;

    void eliminar(Long id) throws SQLException;


}
