<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.List,model.Item" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Items</title>
</head>
<body>
<h2>Manage Items</h2>

<% if (request.getAttribute("success") != null) { %>
<p style="color:green;"><%= request.getAttribute("success") %></p>
<% } %>

<!-- Add Item -->
<form action="item" method="post">
    <input type="hidden" name="action" value="add">
    Name: <input type="text" name="name" required>
    Price per Unit: <input type="number" step="0.01" name="price_per_unit" required>
    <input type="submit" value="Add Item">
    <a href="dashboard.jsp" style="text-decoration:none;">
        <input type="button" value="Back" style="margin-left:10px;">
    </a>
</form>

<hr>

<!-- Update Item -->
<form action="item" method="post">
    <input type="hidden" name="action" value="update">
    Item ID: <input type="number" name="item_id" required>
    New Price per Unit: <input type="number" step="0.01" name="price_per_unit" required>
    <input type="submit" value="Update Item">
</form>

<hr>

<!-- Delete Item -->
<form action="item" method="post">
    <input type="hidden" name="action" value="delete">
    Item ID: <input type="number" name="item_id" required>
    <input type="submit" value="Delete Item">
</form>

<hr>

<!-- Items Table -->
<h3>Existing Items</h3>
<table border="1">
    <tr>
        <th>Item ID</th>
        <th>Name</th>
        <th>Price per Unit</th>
    </tr>
    <%
        List<Item> items = (List<Item>) request.getAttribute("items");
        if (items != null) {
            for (Item item : items) {
    %>
    <tr>
        <td><%= item.getItemId() %></td>
        <td><%= item.getName() %></td>
        <td><%= item.getPricePerUnit() %></td>
    </tr>
    <%      }
    }
    %>
</table>

</body>
</html>

