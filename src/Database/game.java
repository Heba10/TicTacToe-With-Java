/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author heba
 */
public class game {
      Integer id;
    String vsPlayerName;
    String startPlayerName;
    String winnerName;
    Date datetime;
    boolean recorded;
 
     Connection conn = null;	
    Statement stat = null; //to make quary
    ResultSet rs =null; //to save resalt
     //PreparedStatment ps=con.PrepareStatement("");
    public game() {
    id=0;
    vsPlayerName=null;
    startPlayerName=null;
    winnerName=null;
    // datetime=;
    
   recorded=false;
     
    }
    
    
}
