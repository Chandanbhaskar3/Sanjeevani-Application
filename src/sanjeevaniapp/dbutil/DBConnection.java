 
package sanjeevaniapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class DBConnection {
    private static Connection conn = null;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
            System.exit(0);
        }
        try{
             conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-BC3C5VE:1521/xe","project3","5045");
             System.err.println("connection open successfully");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }
    public static Connection getConnection(){
    return conn;
    } 
    public static void closeConnection(){
        if(conn != null){
            try {
                 conn.close();
                 System.out.println("conn close successfully");
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
    }
}
