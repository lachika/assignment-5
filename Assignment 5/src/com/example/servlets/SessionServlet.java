package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Cookie example
        Cookie[] cookies = request.getCookies();
        String username = null;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
        
        // URL rewriting example
        String encodedURL = response.encodeURL(request.getRequestURI());
        
        // Session attributes
        String theme = (String) session.getAttribute("theme");
        if (theme == null) {
            theme = "light";
            session.setAttribute("theme", theme);
        }
        
        request.setAttribute("username", username);
        request.setAttribute("encodedURL", encodedURL);
        request.setAttribute("theme", theme);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/session.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String theme = request.getParameter("theme");
        
        // Set cookie
        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
        response.addCookie(usernameCookie);
        
        // Set session attribute
        HttpSession session = request.getSession();
        session.setAttribute("theme", theme);
        
        response.sendRedirect("session");
    }
}