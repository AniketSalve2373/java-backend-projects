package main.util;

import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("resources/db.properties"));

            String url = prop.getProperty("url");
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");

            connection = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
