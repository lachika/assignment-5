package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.JSONObject;

public class AjaxServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        
        // Create JSON response
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "success");
        jsonResponse.put("message", "Hello, " + name + "! Your request was processed successfully.");
        
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // Write JSON response
        response.getWriter().write(jsonResponse.toString());
    }
}