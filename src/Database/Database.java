/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author heba
 */
public class Database{
    
  
    public static void main(String[] args) {
        
        
             try{
   Class.forName("org.sqlite.JDBC");
    String url="jdbc:sqlite:temp.db";
    Connection con=DriverManager.getConnection(url);
     //Statement st=con.createStatement();
    System.out.println("succesful");
    
    
}catch(Exception ex){

System.out.println(" Not succesful");
}
        
    }
    
}
