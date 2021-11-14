/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Alexander
 */
public class conexion {
    
    String strConexion="jdbc:sqlite:C:/Users/Alexander/Desktop/db/sistema.s3db";
    Connection conn= null;
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection(strConexion);
            
            System.out.println("Conexión establecida");
            
            
        } catch (Exception e) {
            
            System.out.println("Error de Conexión"+e);
            
        }
    }
    
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        
        try {
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
    
        try {
            
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta= pstm.executeQuery();
            return respuesta;
            
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    } 
}








