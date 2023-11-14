package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/users?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String DB_USERNAME = "Nikita";
    private static final String DB_PASSWORD = "Partymaker35_";
    public static Connection getConnection (){
       Connection connection = null;
       try{
           connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);


       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return connection;
    }


}
