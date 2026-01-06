package istad.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    //create singleton object
    private static Connection conn;

    //Invoke singleton
    public static Connection getInstance() {
        return conn;
    }
    //Initialize singleton object(only 1 time)
    public static void init(){
        if(conn == null){
            try{
                //step1 : load driver
                Class.forName("org.postgresql.Driver");
                //step2: Establish connection
                String url = "jdbc:postgresql://localhost:5432/a01_a1";
                String user = "postgres";
                String password = "180805";
                conn = DriverManager.getConnection(url, user, password);
            }catch (ClassNotFoundException e){
                System.out.println("class not found"+ e.getMessage());
            }catch (SQLException e){
                System.out.println("SQL Exception: " + e.getMessage());
            }
        }else {
            System.out.println("Connection already initialize");
        }
    }
}
