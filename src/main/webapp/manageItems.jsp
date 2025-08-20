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
    <link rel="stylesheet" type="text/css" href="CSS/manageItems.css">
</head>
<body>
<div id="validation" class="validation"></div>

<h2 class="page-title">Manage Items</h2>

<% if (request.getAttribute("success") != null) { %>
<script>
    window.onload = function() {
        showValidation("<%= request.getAttribute("success") %>");
    }
</script>
<% } %>

<!-- Add Item -->
<form action="item" method="post" class="form-box">
    <input type="hidden" name="action" value="add">
    <label>Name:</label>
    <input type="text" name="name" required>

    <label>Price per Unit:</label>
    <input type="number" step="0.01" name="price_per_unit" required>

    <div class="button-group">
        <input type="submit" value="Add Item">
        <a href="dashboard.jsp" style="text-decoration:none;">
            <input type="button" value="Back">
        </a>
    </div>
</form>

<hr>

<!-- Update Item -->
<form action="item" method="post" class="form-box">
    <input type="hidden" name="action" value="update">

    <label>Item ID:</label>
    <input type="number" name="item_id" required>

    <label>New Price per Unit:</label>
    <input type="number" step="0.01" name="price_per_unit" required>

    <div class="button-group">
        <input type="submit" value="Update Item">
    </div>
</form>

<hr>

<!-- Items Table -->
<h3 class="table-title">Existing Items</h3>
<div class="table-container">
    <table>
        <tr>
            <th>Item ID</th>
            <th>Name</th>
            <th>Price per Unit</th>
            <th>Action</th>
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
            <td>
                <form action="item" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="item_id" value="<%= item.getItemId() %>">
                    <button type="submit" class="delete-btn" onclick="return confirm('Are you sure you want to delete this item?');">
                        Delete
                    </button>
                </form>
            </td>
        </tr>
        <%      }
        }
        %>
    </table>
</div>

<script>
    function showValidation(message) {
        let validation = document.getElementById("validation");
        validation.innerText = message;
        validation.className = "validation show";
        setTimeout(function(){
            validation.className = validation.className.replace("show", "");
        }, 3000);
    }
</script>
</body>
</html>
