<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session Management</title>
    <style>
        body {
            background-color: <%= "dark".equals(session.getAttribute("theme")) ? "#333" : "#fff" %>;
            color: <%= "dark".equals(session.getAttribute("theme")) ? "#fff" : "#333" %>;
        }
    </style>
</head>
<body>
    <h1>Session Management Demo</h1>
    
    <% if (request.getAttribute("username") != null) { %>
        <p>Cookie value: <%= request.getAttribute("username") %></p>
    <% } %>
    
    <p>Encoded URL: <%= request.getAttribute("encodedURL") %></p>
    <p>Current theme: <%= session.getAttribute("theme") %></p>
    
    <h2>Change Preferences</h2>
    <form action="session" method="post">
        Username: <input type="text" name="username" 
                         value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>"><br>
        Theme: 
        <select name="theme">
            <option value="light" <%= "light".equals(session.getAttribute("theme")) ? "selected" : "" %>>Light</option>
            <option value="dark" <%= "dark".equals(session.getAttribute("theme")) ? "selected" : "" %>>Dark</option>
        </select><br>
        <input type="submit" value="Save Preferences">
    </form>
</body>
</html>