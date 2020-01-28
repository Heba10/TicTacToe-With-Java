/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author heba
 */
public class player {
    Integer id;
    String name;
    Integer score;
    Integer gamecountVsComputer;
    Integer gamecountVsPlayer;
  //  String sql="Select * from player";
  //  pst=con.prepareStatment(sql);
  //  rs=pst.executeQuery();
     Connection conn = null;	
    Statement stat = null; //to make quary
    ResultSet rs =null; //to save resalt
    
    //PreparedStatment ps=con.PrepareStatement("");
    public player() {
    id=0;
    name=null;
    score=0;
    gamecountVsComputer=0;
    gamecountVsPlayer=0 ; 
        
        
    }
  
    boolean pushPlayerToDB(Connection conn){
    
        String sql = "INSERT INTO player VALUES (0, value2, value3, ...)";
        return false;
    
    
    }

    public player(ResultSet rs) throws SQLException {
      id = rs.getInt(1);
       name = rs.getString(2);
        score = rs.getInt(3);
        gamecountVsComputer = rs.getInt(4);
        gamecountVsPlayer = rs.getInt(5);
    }

    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
       this.id = id;
      //getInt(1)=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGamecountVsComputer() {
        return gamecountVsComputer;
    }

    public void setGamecountVsComputer(Integer gamecountVsComputer) {
        this.gamecountVsComputer = gamecountVsComputer;
    }

    public Integer getGamecountVsPlayer() {
        return gamecountVsPlayer;
    }

    public void setGamecountVsPlayer(Integer gamecountVsPlayer) {
        this.gamecountVsPlayer = gamecountVsPlayer;
    }
    
    
    
    
    
}
