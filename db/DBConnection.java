package db;

import org.eigenbase.xom.MetaDef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;


    private DBConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
           // Class.forName("com.mysql.jdbc.Driver");
            //DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagement","root","1234");
           connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagement?createDatabaseIfNotExist=true","root","1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public static DBConnection getInstance(){
        return (dbConnection==null)? dbConnection=new DBConnection():dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
