<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Customer</title>
    <style>
        .container { display: flex; }
        .form-section { margin-right: 40px; }
        .table-section { min-width: 300px; }
    </style>
</head>
<body>
<h2>Edit Customer</h2>
<div class="container">
    <div class="form-section">
        <form action="editCustomer" method="post">
            Account No: 
            <input type="number" name="account_no" value="<%= request.getParameter("account_no") != null ? request.getParameter("account_no") : "" %>" required>
            <input type="submit" name="search" value="Search">
            <br><br>
            Name: <input type="text" name="name" value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"><br><br>
            Address: <input type="text" name="address" value="<%= request.getAttribute("address") != null ? request.getAttribute("address") : "" %>"><br><br>
            Telephone: <input type="text" name="telephone" value="<%= request.getAttribute("telephone") != null ? request.getAttribute("telephone") : "" %>"><br><br>
            <input type="submit" name="update" value="Update Customer">
            <a href="dashboard.jsp" style="text-decoration:none;">
                <input type="button" value="Back" style="margin-left:10px;">
            </a>
        </form>
        <% if (request.getAttribute("success") != null) { %>
            <p style="color:green;"><%= request.getAttribute("success") %></p>
        <% } %>
    </div>
    <div class="table-section">
        <% if (request.getAttribute("customer") != null) { 
            // Assuming customer is a JavaBean or Map with getters
            Object customerObj = request.getAttribute("customer");
            // Replace with your actual customer object and fields
        %>
        <table border="1">
            <tr><th>Account No</th><th>Name</th><th>Address</th><th>Telephone</th><th>Units Consumed</th></tr>
            <tr>
                <td><%= ((Customer)customerObj).getAccountNo() %></td>
                <td><%= ((Customer)customerObj).getName() %></td>
                <td><%= ((Customer)customerObj).getAddress() %></td>
                <td><%= ((Customer)customerObj).getTelephone() %></td>
                <td><%= ((Customer)customerObj).getUnitsConsumed() %></td>
            </tr>
        </table>
        <% } %>
    </div>
</div>
</body>
</html>
