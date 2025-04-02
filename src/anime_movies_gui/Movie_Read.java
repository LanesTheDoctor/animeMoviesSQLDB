package anime_movies_gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movie_Read 
{
    private final String DB_URL = "jdbc:mysql://localhost:3306/animeDB?serverTimezone=UTC";
    private String db_usrName;
    private String db_usrPwd;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private int recordCount;
    private String errorMessage;
    private Object [][] objDataSet;
    private int countData;

    public Movie_Read (String sql, String type)
    {
        // initialise
        db_usrName = "root";
        db_usrPwd = "";
        recordCount = 0;
        errorMessage = "";
        
        try
            {
            // make connection and execute SQL query
            conn = DriverManager.getConnection(DB_URL, db_usrName, db_usrPwd);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            // get record count
            if (rs != null)
            {
                rs.beforeFirst();
                rs.last();
                recordCount = rs.getRow();
            }

            System.out.println("Record Count: " + recordCount);
            // display attributes of each record in a while loop
            if (recordCount > 0)
            {
                int counter = 0;
                objDataSet = new Object[recordCount][];
                countData = 0;

                // start at beginning of record set
                rs.beforeFirst();

                // loop through each record set and display attributes
                while ( rs.next() )
                {
                    if (type.equals("select_movies"))
                    {
                        Object [] obj = new Object[6];
                        obj[0] = rs.getInt("movieID");
                        obj[1] = rs.getString("title");
                        obj[2] = rs.getInt("releaseYear");
                        obj[3] = rs.getString("director");
                        obj[4] = rs.getInt("length");
                        obj[5] = rs.getString("rating");
                        objDataSet[counter] = obj;
                        counter++;
                    }
                } // end while loop
            }

            else
            {
                // no records found
            }

            // close the connection (#5)
            conn.close();

        } // end try block
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
    
    public int getRecordCount()
    {
        return recordCount;
    }
    
    public String getErrorMessage()
    {
        return errorMessage;
    }
    
    public Object[][] getObjDataSet()
    {
        return objDataSet;
    }
    
    public int getCountData()
    {
        return countData;
    }
}
