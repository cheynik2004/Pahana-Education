<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Login</title>
    <link rel="stylesheet" type="text/css" href="CSS/login.css">
</head>
<body>
<h2>Login</h2>
<form action="login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br><br>
    <label>Password:</label>
    <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>
<%
    if (request.getAttribute("error") != null) {
%>
<p style="color:red;"><%= request.getAttribute("error") %></p>
<%
    }
%>
</body>
</html>

