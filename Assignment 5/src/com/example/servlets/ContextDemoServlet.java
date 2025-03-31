package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextDemoServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        Integer visitCount = (Integer) context.getAttribute("visitCount");
        
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        
        context.setAttribute("visitCount", visitCount);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>ServletContext Demo</title></head>");
        out.println("<body><h1>Application Visit Count</h1>");
        out.println("<p>Total visits: " + visitCount + "</p>");
        out.println("</body></html>");
    }
}