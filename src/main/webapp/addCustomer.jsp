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
    <link rel="stylesheet" type="text/css" href="./CSS/addCustomer.css">
</head>
<body>
<h2>Add New Customer</h2>
<form action="addCustomer" method="post">
    <label for="account_no">Account No</label>
    <input type="number" name="account_no" required>

    <label for="name">Name</label>
    <input type="text" name="name" required>

    <label for="address">Address</label>
    <input type="text" name="address" required>

    <label for="telephone">Telephone</label>
    <input type="text" name="telephone" required>

    <div class="button-group">
        <input type="submit" value="Add Customer">
        <input type="button" value="Cancel" onclick="window.location.href='dashboard.jsp'">
    </div>
</form>


<% if (request.getAttribute("success") != null) { %>
    <p style="color:green;"><%= request.getAttribute("success") %></p>
<% } %>
</body>
</html>
