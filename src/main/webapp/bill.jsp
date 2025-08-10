<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="dao.CustomerDAO,dao.ItemDAO,model.Customer,model.Item,java.util.List" %>
<%
    CustomerDAO cdao = new CustomerDAO();
    ItemDAO idao = new ItemDAO();
    List<Customer> customers = cdao.getAllCustomers();
    List<Item> items = idao.getAllItems();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Generate Bill</title>
    <style>
        .inline-tables { display: flex; gap: 40px; }
        .inline-tables > div { min-width: 300px; }
    </style>
</head>
<body>
<h2>Generate Bill</h2>
<form action="billInquiry.jsp" method="post">
    Account No: <input type="number" name="account_no" required>
    Item No: 
    <select name="item_no" required>
        <% for (Item item : items) { %>
            <option value="<%= item.getItemId() %>"><%= item.getItemId() %></option>
        <% } %>
    </select>
    Quantity: <input type="number" name="quantity" required>
    <input type="submit" name="generate" value="Generate">
        <a href="dashboard.jsp" style="text-decoration:none;">
        <input type="button" value="Back" style="margin-left:10px;">
    </a>
</form>
<hr>
<div class="inline-tables">
    <div>
        <h3>Customers</h3>
        <table border="1">
            <tr><th>Account No</th><th>Name</th><th>Address</th><th>Telephone</th></tr>
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
    <div>
        <h3>Menu Items</h3>
        <table border="1">
            <tr><th>Item No</th><th>Name</th><th>Price per Unit</th></tr>
            <% for (Item item : items) { %>
            <tr>
                <td><%= item.getItemId() %></td>
                <td><%= item.getName() %></td>
                <td><%= item.getPricePerUnit() %></td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>

