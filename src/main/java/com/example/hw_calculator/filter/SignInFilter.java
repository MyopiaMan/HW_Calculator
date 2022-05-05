package com.example.hw_calculator.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class SignInFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;

        final HttpSession session = req.getSession(false);//false
        //переадресация на сервлеты входа и регистрации
        String loginURL = req.getContextPath() + "/" ;//"/signIn"
        String signUpURL = req.getContextPath() + "/signUp" ;//1

        boolean loggedIn = session != null && session.getAttribute("user") != null; //4
//                && session.getAttribute("password") != null;//5
        //если сессия уже создана
        boolean loginRequest = req.getRequestURI().equals(loginURL);
        boolean signUpRequest = req.getRequestURI().equals(signUpURL);//2

        if (loggedIn || loginRequest || signUpRequest){ //3
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURL);
        }

////#1
////        if (session == null || session.getAttribute("login") == null) {
////            resp.sendRedirect(req.getContextPath() + "/signIn"); // No logged-in user found, so redirect to login page.
////        } else {
////            filterChain.doFilter(request, response); // Logged-in user found, so just continue request.
////        }
////#2
////        if(session != null &&
////                session.getAttribute("login") != null &&
////                session.getAttribute("password") != null){
////            req.getRequestDispatcher("/pages/userPage.jsp").forward(req, resp);
////        } else{
////            req.getRequestDispatcher("/index.jsp").forward(req, resp);
////        }
    }
}
