package anime_movies_gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movie_Write 
{
    private final String DB_URL = "jdbc:mysql://localhost:3306/animeDB?serverTimezone=UTC";
    private String db_usrName;
    private String db_usrPwd;
    private Connection conn;
    private Statement stmt;
    private String errorMessage;
    
    public Movie_Write (String sql) //start constructor
    {
        // initialise
        db_usrName = "root";
        db_usrPwd = "";
        errorMessage = "";
        
        try
        {
            // make connection and execute SQL query
            conn = DriverManager.getConnection(DB_URL, db_usrName, db_usrPwd);
            stmt = conn.createStatement();

            // executeUpdate(sql) used for INSERT INTO, UPDATE and DELETE FROM statements
            stmt.executeUpdate(sql);
            
            // close the connection
            conn.close();
        }
        
        // catch SQL Exceptions
        catch (SQLException e)
        {
            errorMessage = e.getMessage();
            System.out.println("SQL exception: " + errorMessage);
        }
        
        // catch any other possible exception
        catch (Exception e)
        {
            errorMessage = e.getMessage();
            System.out.println("Other exception: " + errorMessage);
        }
    } // end constructor method
    
    public String getErrorMessage()
    {
        return errorMessage;
    }

}
