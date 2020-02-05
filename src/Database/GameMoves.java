
package Database;

//(id , xPos , yPos,game id)

import GameLogic.BoardPostion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GameMoves
{
    int gameId;
    Vector<BoardPostion> moves;
    
            
    public GameMoves() 
    {
        moves = new Vector<>();
    }
    public GameMoves(ResultSet rs) throws SQLException
    {
        moves = new Vector<>();
//        gameId=rs.getInt(4);
        while(rs.next())
        {
            addMove(rs.getInt(2), rs.getInt(3));
        }
    }
    
    public void addMove(int x,int y,char c)
    {
        moves.add(new BoardPostion(x,y,c));
    }
    public void addMove(int x,int y)
    {
        moves.add(new BoardPostion(x,y));
    }

    public int getGameId() {
        return gameId;
    }

    public Vector<BoardPostion> getMoves() {
        return moves;
    }
    
    
}
