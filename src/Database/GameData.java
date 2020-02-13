
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import Database.GameMoves;
//game (id,vs player name,start player name ,winner name, datetime,recorded)

public class GameData {
    
    
    int id;
    String name;
    String vsPlayerName;
    String startedPlayerName;
    String winnerName;
    String dateTime;
    int isRecorded;
    String startSymbol;
    GameMoves gameMoves;
    
    
    public GameData()
    {
         id=0;
         name=null;
         vsPlayerName=null;
         startedPlayerName=null;
         winnerName=null;
         dateTime=Instant.now().toString();
         isRecorded=0;
         gameMoves= new GameMoves();
         
    }
    public GameData(int id, String startSymbol)
    {
         this.id=id+1;
         name=null;
         vsPlayerName=null;
         startedPlayerName=null;
         winnerName=null;
         dateTime=Instant.now().toString();
         isRecorded=0;
         gameMoves= new GameMoves();
         this.startSymbol=startSymbol;
    }
    
    
     public GameData(ResultSet rs,GameMoves gameMoves) throws SQLException
    {
        
            id=rs.getInt(1);
            name=rs.getString(2);
            vsPlayerName=rs.getString(3);
            startedPlayerName=rs.getString(4);
            winnerName=rs.getString(5);
             dateTime=rs.getString(6);
            isRecorded=rs.getInt(7);
            startSymbol=rs.getString(8);
            this.gameMoves=gameMoves;
       
    }
    
    public void setId(int n)
    {
        id=n;
    }
    
    public void setVsPlayerName(String name)
    {
        vsPlayerName=name;
    }
   

    public String getDateTime() {
        return dateTime;
    }

    public int getId() {
        return id;
    }

    public int getIsRecorded() {
        return isRecorded;
    }

    public String getStartedPlayerName() {
        return startedPlayerName;
    }

    public String getVsPlayerName() {
        return vsPlayerName;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public GameMoves getGameMoves() {
        return gameMoves;
    }

    public String getName() {
        return name;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setGameMoves(GameMoves gameMoves) {
        this.gameMoves = gameMoves;
    }

    public void setIsRecorded(int isRecorded) {
        this.isRecorded = isRecorded;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartedPlayerName(String startedPlayerName) {
        this.startedPlayerName = startedPlayerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void setStartSymbol(String startSymbol) {
        this.startSymbol = startSymbol;
    }

    public String getStartSymbol() {
        return startSymbol;
    }
    
    
    
    
    
    
    
}
