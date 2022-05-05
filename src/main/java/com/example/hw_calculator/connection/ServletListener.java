package com.example.hw_calculator.connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//public class ServletListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ServletContext sc = sce.getServletContext();
//        String URL = sc.getInitParameter("jdbc:mysql://localhost:3306/calculator");
//        String USER = sc.getInitParameter("root");
//        String PASSWORD = sc.getInitParameter("root");
//        SQLDatabaseConnection db = new SQLDatabaseConnection (URL, USER, PASSWORD);
//        sc.setAttribute("db", db);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {}
//}
