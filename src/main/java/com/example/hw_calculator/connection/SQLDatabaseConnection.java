package com.example.hw_calculator.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {

//    public SQLDatabaseConnection(String URL, String USER, String PASSWORD) {//1
//    }

    public static Connection initializeConnection() throws ClassNotFoundException, SQLException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/calculator";
        String USER = "root";
        String PASSWORD = "root";
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }
}
