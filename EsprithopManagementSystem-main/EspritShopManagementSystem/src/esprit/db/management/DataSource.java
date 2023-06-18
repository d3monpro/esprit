
package esprit.db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataSource {
 private static DataSource dataSource;
    private Connection connection;
    
    public DataSource(){
        createConnection();
    }
    
    private Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantmanagement","root","");
            System.out.println("Database succefully connected\n--------------------------------------------------\n");

        }catch (ClassNotFoundException ex){
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
    
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static DataSource getInstance(){
        if(dataSource == null){
            return new DataSource();
        }else{
            return dataSource;
        }
    }
    
    public Connection getConnection(){
        return connection;
    }    
}
