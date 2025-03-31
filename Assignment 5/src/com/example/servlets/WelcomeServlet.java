package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login");
            return;
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
        dispatcher.forward(request, response);
    }
}