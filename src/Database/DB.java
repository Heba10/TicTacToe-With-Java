
package Database;

import GameLogic.BoardPostion;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;


public class DB {
    
    Connection con;
    ResultSet rs;
    String sql;
    Statement st;
    PreparedStatement pst;

    public DB() throws SQLException
    {
           // Class.forName("org.sqlite.JDBC");
        
              
    }
    public void establishConnection() throws SQLException
    {
            con= DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("connection sucess");
            st=con.createStatement();
    }
    
    public boolean isExist()
    {
        File db=new File("test.db");
        return db.exists();
    }
    
    public boolean createDB() throws IOException
    {
        File db=new File("test.db");
        return db.createNewFile();
    }
    
    public void createTables() throws SQLException
    {
        sql="create table GameData(id INTEGER primary key autoincrement,name string(100) not null ,vsPlayerName string(100) not null, startedPlayerName string(100) not null ,winnerName string(100),dataTime date ,isRecorded integer(10) not null)";
        st.execute(sql);
        sql="create table GameMoves(id integer primary key autoincrement,xPos integer not null,yPos  integer not null,gameId integer REFERENCES GameData(id))";
        st.execute(sql);
        sql="create table PlayerData(id integer primary key autoincrement,name string(100) not null,score integer ,gameCountVsComputer integer ,gameCountVsPlayer integer) ";
        st.execute(sql);
        closeConnection();
    }
   
    public void closeConnection() throws SQLException
    {
        con.close();
    }
    public Connection getCon() {
        return con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public String getSql() {
        return sql;
    }

    public Statement getSt() {
        return st;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }
    
    public void pushPlayer(PlayerData player) throws SQLException
    {
        establishConnection();
        sql="insert into PlayerData (name,score,gameCountVsComputer,gameCountVsPlayer) values (?,?,?,?)";
        pst =con.prepareStatement(sql);
//        pst.setInt(1, player.getId());
        pst.setString(1, player.getName());
        pst.setInt(2, player.getScore());
        pst.setInt(3,player.getGameCountVsComputer());
        pst.setInt(4, player.getGameCountVsPlayer());
        pst.execute();
        con.close();
    }
    
    public PlayerData getPlayer(String name) throws SQLException
    {
        establishConnection();
        sql="select * from PlayerData where name='"+name+"'";
        rs=st.executeQuery(sql);
        return new PlayerData(rs);
    }
    
    public void PushGame(GameData game) throws SQLException
    {
        establishConnection();
        sql="insert into GameData (name,vsPlayerName,startedPlayerName,winnerName,dataTime,isRecorded)values (?,?,?,?,?,?)";
        pst=con.prepareStatement(sql);
        pst.setString(1,game.getName());
        pst.setString(2,game.getVsPlayerName() );
        pst.setString(3,game.getStartedPlayerName());
        pst.setString(4,game.getWinnerName());
        pst.setString(5,game.getDateTime());
        pst.setInt(6, game.getIsRecorded());
        pst.execute();
        con.close();
        
    }
    public GameData getGame(int id) throws SQLException
    {
        establishConnection();
        sql="select * from GameData where id ="+id;
        rs=st.executeQuery(sql);
        return new GameData(rs,getGameMoves(id));
    }
    
    public GameMoves getGameMoves(int id) throws SQLException
    {
        
        establishConnection();
        sql="select * from GameMoves where GameId ="+id;
        ResultSet rs=st.executeQuery(sql);
        return new GameMoves(rs);
    }
    
    public  Vector getAllGames() throws SQLException
    {
        Vector<GameData> games=new Vector<>();
        establishConnection();
        sql="select * from GameData";
        rs=st.executeQuery(sql);
        while(rs.next())
        {
            games.add(new GameData(rs,getGameMoves(rs.getInt(1))));
        }
        return games;
    }
    
   
    
//    public static void main(String[] args) throws SQLException, IOException {
//        DB db=new DB();
//        db.establishConnection();
//        GameData game=db.getGame(1);
//        db.closeConnection();
//        System.out.println(game.getGameMoves().getMoves().size());
//        for(BoardPostion e : game.getGameMoves().getMoves())
//        {
//            
//            System.out.println(e.getX()+" "+e.getY());
//                    
//        }
//          Vector<GameData>games=db.getAllGames();
//          for(GameData g : games)
//          {
//              System.out.println("id= "+g.getId());
//              System.out.println("postions");
//              for(BoardPostion pos:g.getGameMoves().getMoves())
//              {
//                  System.out.println("x= "+pos.getX()+" y= "+pos.getY());
//              }
//          }
//        System.out.println(game.getGameMoves().getMoves().elementAt(1));
//        System.out.println(game.getGameMoves().getMoves().elementAt(2));
//        System.out.println(game.getGameMoves().getMoves().elementAt(3));
        
//    }
    
    
        
    
}
