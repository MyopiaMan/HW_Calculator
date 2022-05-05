package com.example.hw_calculator.servlet;

import com.example.hw_calculator.connection.UserDAO;
import com.example.hw_calculator.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//регистрация
@WebServlet(value = "/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/signUpPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDAO userDao = new UserDAO();
        try{
            User user = userDao.newUserRegistration(username, login, password);
            String startPage;
            if (user == null){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                startPage = "index.jsp";
                String message = "Successful registration. Enter login and password";
                req.setAttribute("message", message);
            } else {
                startPage = "index.jsp";
                String message = "Registration failed. Try again";
                req.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(startPage);
            dispatcher.forward(req, resp);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
