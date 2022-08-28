/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ivanf
 */
public class ConexionBaseDeDatos {
    static private String sql = "jdbc:sqlite:";
    static private String dir = System.getProperty("user.dir");
    static private String baseDatos = "bdreto4.db";
    static private String url = sql + dir + "/" + baseDatos;
    static Connection con = null;
    
    public static Connection Conexion(){      
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Conexion exitosa");
            return con;
        } catch (SQLException ex) {
            con = null;
            ex.printStackTrace();
            System.out.println("No se pudo conectar a la base de datos");
        }
       return con;
    }
    
     public static Connection obtenerConexion(){
        Conexion();
        return con;
    }
    
    public static void cerrarConexion(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexión");
            ex.printStackTrace();
        }
    }
    
}
