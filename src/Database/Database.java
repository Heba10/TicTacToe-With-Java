/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author heba
 */
public class Database{
    
  
    //public static void main(String[] args) {
    Connection conn = null;	
    Statement stat = null; //to make quary
    ResultSet rs =null; //to save resalt
    public Database () throws ClassNotFoundException, SQLException {
    Class.forName("org.sqlite.JDBC");
    String url="jdbc:sqlite:temp.db";
    Connection con=DriverManager.getConnection(url);
    stat = conn.createStatement();
    String sql = " ";
    
    
    
    }
    public Database (String sql) {
        rs= conn.getState().excutetQuary();
        
    
    
    
    
    
    
    }

        
        
        
        
        
        
        
        
           //  try{
   //Class.forName("org.sqlite.JDBC");
   // String url="jdbc:sqlite:temp.db";
    //Connection con=DriverManager.getConnection(url);
     //Statement st=con.createStatement();
   // System.out.println("succesful");
    
    
//}catch(Exception ex){

//System.out.println(" Not succesful");
//}

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

   

   

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
        
    }
    
//}
