package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BasicServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        if (name == null) name = "World";
        
        out.println("<html><head><title>Servlet Example</title></head>");
        out.println("<body><h1>Hello, " + name + "!</h1>");
        out.println("<p>This is a Java Servlet.</p>");
        out.println("<p>Your IP: " + request.getRemoteAddr() + "</p>");
        out.println("<p>User-Agent: " + request.getHeader("User-Agent") + "</p>");
        out.println("</body></html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}