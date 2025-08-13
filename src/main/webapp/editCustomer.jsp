<%@ page language="java" contentType="text/html; charset=UTF-8" import="model.Customer,dao.CustomerDAO,java.util.List" %>
<%
    dao.CustomerDAO cdao = new dao.CustomerDAO();
    java.util.List<Customer> customers = cdao.getAllCustomers();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" type="text/css" href="CSS/editCustomer.css">
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
                <input type="button" value="Go Back to Dashboard" style="margin-left:10px;">
            </a>
        </form>
        <% if (request.getAttribute("success") != null) { %>
            <p style="color:green;"><%= request.getAttribute("success") %></p>
        <% } %>
    </div>
    <div class="table-section">
        <h3>All Customers</h3>
        <table border="1">
            <tr>
                <th>Account No</th>
                <th>Name</th>
                <th>Address</th>
                <th>Telephone</th>
            </tr>
            <% for (Customer c : customers) { %>
            <tr>
                <td><%= c.getAccountNo() %></td>
                <td><%= c.getName() %></td>
                <td><%= c.getAddress() %></td>
                <td><%= c.getTelephone() %></td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>