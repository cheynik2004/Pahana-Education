<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<h2>Add New Customer</h2>
<form action="addCustomer" method="post" style="display:inline;">
    Account No: <input type="number" name="account_no" required><br><br>
    Name: <input type="text" name="name" required><br><br>
    Address: <input type="text" name="address" required><br><br>
    Telephone: <input type="text" name="telephone" required><br><br>
    <input type="submit" value="Add Customer">
    <a href="dashboard.jsp" style="text-decoration:none;">
        <input type="button" value="Back" style="margin-left:10px;">
    </a>
</form>
<% if (request.getAttribute("success") != null) { %>
    <p style="color:green;"><%= request.getAttribute("success") %></p>
<% } %>
</body>
</html>
