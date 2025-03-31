package com.example.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class LoggingFilter implements Filter {
    
    private FilterConfig filterConfig;
    
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String ipAddress = httpRequest.getRemoteAddr();
        String requestURI = httpRequest.getRequestURI();
        Date date = new Date();
        
        System.out.println("[" + date + "] IP: " + ipAddress + " Requested: " + requestURI);
        
        chain.doFilter(request, response);
    }
    
    public void destroy() {
        // Cleanup code if needed
    }
}