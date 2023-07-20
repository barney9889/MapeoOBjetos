package org.example.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    public static String url="jdbc:mysql://localhost:3306/java_curso";
    public static String username="root";
    public static String password="1234";

    public static Connection conexionJDBC;



public static Connection getConexionJDBC() throws SQLException{
        if(conexionJDBC==null){
          conexionJDBC = DriverManager.getConnection(url,username,password);
         }
        return conexionJDBC;
    }

}
