
package Database;

import java.sql.*;


public class DBConnection {
    
    Connection con;
    ResultSet rs;
    String sql;
    Statement st;

    public DBConnection()
    {
       
        try
        {
           // Class.forName("org.sqlite.JDBC");
            con= DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("connection sucess");
            st=con.createStatement();
            
        } 
        catch (Exception e)
        {
             e.printStackTrace();
        }
        
    }
    
    public  DBConnection(String sqlString)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            con= DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("connection sucess");
             st=con.createStatement();
             sql=sqlString;
            rs=st.executeQuery(sql);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
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
    
    
    public static  void main(String args[])
        {
         DBConnection b= new DBConnection();
        }
    
    
    
    
        
    
}
