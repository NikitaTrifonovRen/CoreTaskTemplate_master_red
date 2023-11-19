package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.hibernate.Session;

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
    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/users?serverTimezone=Europe/Moscow&useSSL=false");
            prop.setProperty("hibernate.connection.username", "Nikita");
            prop.setProperty("hibernate.connection.password", "Partymaker35_");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            //prop.setProperty("hibernate.hbm2ddl.auto", "update");

            concreteSessionFactory = new org.hibernate.cfg.Configuration()
                    .addProperties(prop)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }



}
