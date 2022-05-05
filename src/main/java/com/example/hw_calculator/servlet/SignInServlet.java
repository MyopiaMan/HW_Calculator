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

//аутентификация
@WebServlet(value = "/signIn")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/userPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        String username = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDAO userDao = new UserDAO();
        try {
            User user = userDao.loginCheck(login, password);
            String startPage = "index.jsp";
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                startPage = "pages/userPage.jsp";
            } else {
                String message = "Invalid login or password. Try again";
                req.setAttribute("message", message);
//                String signInErrorMessage = "Invalid login or password. Try again";
//                req.setAttribute("signInErrorMessage", signInErrorMessage);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(startPage);
            dispatcher.forward(req, resp);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        //закомментил после дао
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//
//        boolean signIn = SignInCheck.check(login, password);
//
//        if (signIn) {
//            // перенаправить на main
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/userPage.jsp");
//            requestDispatcher.forward(req, resp);
//        } else {
//            // показать туже страницу с логином и паролем только добавить поле с ошибочными данными
//            req.setAttribute("login", login);
//            req.setAttribute("password", password);
//            req.setAttribute("errorMessage", "Неправильный логин или пароль!");
//
//            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
//            //forward - фоновое перенаправление
//            //redirect - явное перенаправление
//        }
//    }
    //закомментил после дао
//    public static boolean check(String login, String password) {
//        boolean result = false;
//        try {
//            Connection con = UserDAO.initializeConnection(); //SQLDatabaseConnection.initializeConnection();
//            PreparedStatement statement = con.prepareStatement("select * from calc_users where login = ? and password = ?");//CHECK_AUTH
//            statement.setString(1, login);
//            statement.setString(2, password);
//
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) result = true;
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("Сломались на аутентификации Пользователя!");
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
//        }
//        return result;
//    }
}