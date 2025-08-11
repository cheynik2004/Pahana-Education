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
    Account No: <input type="number" name="account_no" required min="1"><br><br>
    Name: <input type="text" name="name" required pattern="[A-Za-z0-9 ]+" title="Only letters, numbers, and spaces allowed"><br><br>
    Address: <input type="text" name="address" required pattern="[A-Za-z0-9 ,.-]+" title="Only letters, numbers, spaces, comma, dot, and dash allowed"><br><br>
    Telephone: <input type="text" name="telephone" required pattern="\d{10}" maxlength="10" title="Enter a 10-digit number"><br><br>
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
