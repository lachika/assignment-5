package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.example.model.User;

public class LoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // In a real application, you would validate against a database
        if (User.isValidUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}