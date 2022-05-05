package com.example.hw_calculator.connection;

import com.example.hw_calculator.entity.User;

import java.sql.*;

public class UserDAO {

//    public static Connection initializeConnection() throws ClassNotFoundException, SQLException {
//        String dbDriver = "com.mysql.jdbc.Driver";
//        String URL = "jdbc:mysql://localhost:3306/calculator";
//        String USER = "root";
//        String PASSWORD = "root";
//        Class.forName(dbDriver);
//        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//        return con;
//    }

    public User loginCheck (String login, String password) throws SQLException, ClassNotFoundException {
        Connection con = SQLDatabaseConnection.initializeConnection(); //UserDAO.initializeConnection();
        PreparedStatement statement = con.prepareStatement(
                "select * from calc_users where login = ? and password = ?");
        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        User user = null;

        if (resultSet.next()){
            user = new User();
            user.setUsername(resultSet.getString("username"));
        }
        con.close();
        return user;
    }

    public User newUserRegistration (String username, String login, String password)
            throws SQLException, ClassNotFoundException {
        Connection con = SQLDatabaseConnection.initializeConnection(); //UserDAO.initializeConnection();
        PreparedStatement statement = con.prepareStatement(
                "insert into calc_users (username, login, password) values (?, ?, ?)");//CHECK_AUTH
//        "select * from calc_users where login = ? and password = ?"
//        "insert into calc_users (username, login, password) values (?, ?, ?)"
        statement.setString(1, username);
        statement.setString(2, login);
        statement.setString(3, password);
        int i = statement.executeUpdate();

        User user = null;

        if (i == 3){
            user = new User();
        }
        statement.close();
        con.close();
        return user;
    }
}
