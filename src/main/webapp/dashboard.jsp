<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" %>
<%
    if (session.getAttribute("loggedUser") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Dashboard</title>
</head>
<body>
<h2>Welcome to Pahana Edu Billing System</h2>
<ul>
    <li><a href="addCustomer.jsp">Add Customer</a></li>
    <li><a href="editCustomer.jsp">Edit Customer</a></li>
    <li><a href="item">Manage Items</a></li>
    <li><a href="bill.jsp">Generate Bill</a></li>
    <li><a href="help.jsp">Help</a></li>
    <li><a href="logout">Logout</a></li>
</ul>
</body>
</html>
