
package Database;

//(id,name,score,gamecount vs computer , game count vs player  )

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerData
{
    int id,score,gameCountVsComputer,gameCountVsPlayer;
    String name;
    

    public PlayerData()
    {
         id=0;
         score=0;
         gameCountVsComputer=0;
         gameCountVsPlayer=0;
         name=null;
         
    }
    
    public PlayerData(ResultSet rs) throws SQLException
    {
        
        
            id=rs.getInt(1);
            name=rs.getString(2);
            score=rs.getInt(3);
            gameCountVsComputer=rs.getInt(4);
            gameCountVsPlayer=rs.getInt(5);
            
       
         
    }

    public void setGameCountVsComputer(int countVsComputer) {
        gameCountVsComputer = countVsComputer;
    }

    public void setGameCountVsPlayer(int CountVsPlayer) {
        gameCountVsPlayer = CountVsPlayer;
    }

    public void setId(int n) {
        id = n;
    }

    public void setName(String n) {
        name = n;
    }

    public void setScore(int s) {
        score = s;
    }

    public int getGameCountVsComputer() {
        return gameCountVsComputer;
    }

    public int getGameCountVsPlayer() {
        return gameCountVsPlayer;
    }

    public int getId() {    
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
}
