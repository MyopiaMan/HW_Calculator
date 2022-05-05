package com.example.hw_calculator.servlet;

import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(value = "/calc")
public class CalculatorServlet extends HttpServlet {

//    Logger logger = Logger.getLogger("NewLog");
//    Logger logger = LoggerFactory.getLogger("NewLog");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        switch (operation){
            case "sum":
                req.setAttribute("result", num1 + num2);
                break;
            case "diff":
                req.setAttribute("result", num1 - num2);
                break;
            case "mult":
                req.setAttribute("result", num1 * num2);
                break;
            case "div":
                req.setAttribute("result", num1 / num2);
                break;
        }
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}

