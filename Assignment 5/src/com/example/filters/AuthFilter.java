package com.example.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthFilter implements Filter {
    
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession session = httpRequest.getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        
        chain.doFilter(request, response);
    }
    
    public void destroy() {
        // Cleanup code
    }
}