/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ivanf
 */
public class Consultas {
    
    public boolean ingresar(CuerpoDeAgua cuerpo){
        
        PreparedStatement prepared = null;
        Connection co = ConexionBaseDeDatos.Conexion();
        
        String sentencia = "INSERT INTO CuerpoDeAgua(id_CuerpoAgua, nombre_CuerpoAgua, municipio_CuerpoAgua, tipoCuerpoAgua, tipoAgua, irca_CuerpoAgua, nivelRiesgo_CuerpoAgua) VALUES (?,?,?,?,?,?,?)";
        
        try{
            
            prepared = co.prepareStatement(sentencia);
            prepared.setString(1, Integer.toString(cuerpo.getIdCuerpoDeAgua()));
            prepared.setString(2, cuerpo.getNombre());
            prepared.setString(3, cuerpo.getMunicipio());
            prepared.setString(4, cuerpo.getTipoCuerpoAgua());
            prepared.setString(5, cuerpo.getTipoAgua());
            prepared.setDouble(6, cuerpo.getIrca());
            prepared.setString(7, cuerpo.getNivel());
            prepared.execute();
            return true;
            
        }catch(SQLException ex){
            System.err.println(ex);
            return false;
        }finally{
            try{
                co.close();
                System.out.println("Conexion Cerrada!");
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
    }  

    public boolean editar(CuerpoDeAgua cuerpo){
        
        PreparedStatement prepared = null;
        Connection co = ConexionBaseDeDatos.Conexion();
        
        String sentencia = "UPDATE CuerpoDeAgua SET nombre_CuerpoAgua=?, municipio_CuerpoAgua=?, tipoCuerpoAgua=?, tipoAgua=?, irca_CuerpoAgua=? WHERE id_CuerpoAgua=?";
        
        try{
            System.out.println("El id del cuerpo de agua: " + cuerpo.getIdCuerpoDeAgua());
            prepared = co.prepareStatement(sentencia);
            prepared.setString(1, cuerpo.getNombre());
            prepared.setString(2, cuerpo.getMunicipio());
            prepared.setString(3, cuerpo.getTipoCuerpoAgua());
            prepared.setString(4, cuerpo.getTipoAgua());
            prepared.setDouble(5, cuerpo.getIrca());
            //prepared.setString(6, cuerpo.getNivelRiesgo());
            prepared.setString(6, Integer.toString(cuerpo.getIdCuerpoDeAgua()));
            prepared.execute();
            
            return true;
            
        }catch(SQLException ex){
            System.err.println(ex);
            return false;
        }finally{
            try{
                co.close();
                System.out.println("Conexion Cerrada (EDITAR)");
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
    }  

    public boolean eliminar(CuerpoDeAgua cuerpo){
        
        PreparedStatement prepared = null;
        Connection co = ConexionBaseDeDatos.Conexion();
        
        String sentencia = "DELETE FROM CuerpoDeAgua WHERE id_CuerpoAgua=?";
        
        try{
            
            prepared = co.prepareStatement(sentencia);  
            prepared.setInt(1, cuerpo.getIdCuerpoDeAgua());
            prepared.execute();
            
            return true;
            
        }catch(SQLException ex){
            System.err.println(ex);
            return false;
        }finally{
            try{
                co.close();
                System.out.println("Conexion Cerrada (ELIMINAR)");
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
    }  

    public boolean buscar(CuerpoDeAgua cuerpo){
        
        PreparedStatement prepared = null;
        ResultSet result = null;
        Connection co = ConexionBaseDeDatos.Conexion();
        
        String sentencia = "SELECT * FROM CuerpoDeAgua WHERE id_CuerpoAgua=?";
        
        try{
            
            prepared = co.prepareStatement(sentencia);  
            prepared.setString(1, Integer.toString(cuerpo.getIdCuerpoDeAgua()));
            result = prepared.executeQuery();
            
            if(result.next()){
                
                cuerpo.setIdCuerpoDeAgua(result.getInt("id_CuerpoAgua"));
		cuerpo.setNombre(result.getString("nombre_CuerpoAgua"));
                cuerpo.setMunicipio(result.getString("municipio_CuerpoAgua"));
                cuerpo.setTipoCuerpoAgua(result.getString("tipoCuerpoAgua"));
                cuerpo.setTipoAgua(result.getString("tipoAgua"));
                cuerpo.setIrca(result.getDouble("irca_CuerpoAgua"));
		cuerpo.setNivel(result.getDouble("irca_CuerpoAgua"));
               
                return true;
            }

            return false;
            
        }catch(SQLException ex){
            System.err.println(ex);
            return false;
        }finally{
            try{
                co.close();
                System.out.println("Conexion Cerrada (BUSCAR)");
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
    }  
    
    public ArrayList<CuerpoDeAgua> consulta(){
        ArrayList<CuerpoDeAgua> agua = new ArrayList<>();
       
        agua.clear();
        
        PreparedStatement prepared = null;
        ResultSet result = null;
        Connection co = ConexionBaseDeDatos.Conexion();
        
        String sentencia = "SELECT * FROM CuerpoDeAgua";
        
        try{
            
            prepared = co.prepareStatement(sentencia);  
            result = prepared.executeQuery();
            
            if(result.next()){
                
                while(result.next()){
                CuerpoDeAgua cuerpo = new CuerpoDeAgua();
                cuerpo.setIdCuerpoDeAgua(result.getInt("id_CuerpoAgua"));
		cuerpo.setNombre(result.getString("nombre_CuerpoAgua"));
                cuerpo.setMunicipio(result.getString("municipio_CuerpoAgua"));
                cuerpo.setTipoCuerpoAgua(result.getString("tipoCuerpoAgua"));
                cuerpo.setTipoAgua(result.getString("tipoAgua"));
                cuerpo.setIrca(result.getDouble("irca_CuerpoAgua"));
		cuerpo.setNivel(result.getDouble("irca_CuerpoAgua"));
                
                agua.add(cuerpo);
                    
                }
                
                System.out.println(agua.size());
                return agua;
            }

            return agua;
            
        }catch(SQLException ex){
            System.err.println(ex);
            return agua;
        }finally{
            try{
                co.close();
                System.out.println("Conexion Cerrada (CONSULTA)");
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
    }  
    
}
