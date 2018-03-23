/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmclaves;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @Francisco 
 */
public class Conector {
    
     
    private DataSource ds;
    private Connection conn;
    
    public Conector() {
        ds = SQLDatasource.getSQLLiteDataSource();
        conn = null;
    }
    
    private Connection connectDB(){
        try {
            conn = this.ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    private void disconnectDB(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //COnsulta existencia de Usuario
    
    public boolean getTablauser(String Users){
        
        conn = connectDB();
        String query = "select  userName from Users ";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        PreparedStatement preStmt =null;
        
        
        try{
            consulta = conn.prepareStatement(query);
            resultadotabla = consulta.executeQuery();
                while (resultadotabla.next()){
                if(Users.equals(resultadotabla.getString(1))){
                    return  true ;
                }

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (preStmt != null) {
                    preStmt.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    //Valida Contraseña
    
    public boolean getTablauserPassword(String Passwd){
        
        conn = connectDB();
        String query = "select  userName, UserPasswd == UserPasswd from Users;";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        PreparedStatement preStmt =null;
        
        
        try{
            consulta = conn.prepareStatement(query);
            resultadotabla = consulta.executeQuery();
                while (resultadotabla.next()){
                if(Passwd.equals(resultadotabla.getString(1))){
                    return  true ;
                
                }

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (preStmt != null) {
                    preStmt.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
     //Codigo que consulta usuarios  
      public String getTablaCalendar(String usuarios){
        
        conn = connectDB();
        String query = " select * from Users";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        String w = "";
        PreparedStatement preStmt =null;
        StringBuilder tabla = new StringBuilder(w);
        
        try{
            consulta = conn.prepareStatement(query);
            consulta.setString(1, usuarios);
            resultadotabla = consulta.executeQuery();
            tabla.append("user|\tCorreo\n");
            while (resultadotabla.next()){
                tabla.append(resultadotabla.getInt(1)).append("\t");
                tabla.append(resultadotabla.getString(2)).append("\t");
                tabla.append(resultadotabla.getDouble(3)).append("\n");
            }
            return tabla.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
            finally {
            try {
                if (preStmt != null) {
                    preStmt.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tabla.toString();
    }
    
    
    //Crea Usuario en el Programa
    
    public int insertarUsuarios(String userName, String userEmail, String userPasswd){
        conn = connectDB();
        String query = " insert into Users "
                + "( userName,userEmail, userPasswd)" + 
                " values (?,?,?) ";
        PreparedStatement preStmt =null;
        try {
            preStmt = conn.prepareStatement(query);
            
            
            preStmt.setString(1, userName);
            preStmt.setString(2, userEmail);
            preStmt.setString(3, userPasswd);

           
            
            preStmt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (preStmt != null) {
                    preStmt.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
        
        
    
    }
}

