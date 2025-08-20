<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" type="text/css" href="./CSS/addCustomer.css">
    <link rel="stylesheet" type="text/css" href="./CSS/validation.css">
    <script>
        function showToast(message, isError = false) {
            let toast = document.getElementById("toast");
            toast.innerText = message;
            toast.className = "toast show" + (isError ? " error" : "");
            setTimeout(function(){
                toast.className = toast.className.replace("show", "");
            }, 3000);
        }
        window.onload = function() {
            <% if (request.getAttribute("success") != null) { %>
            showToast("<%= request.getAttribute("success") %>");
            <% } else if (request.getAttribute("error") != null) { %>
            showToast("<%= request.getAttribute("error") %>", true);
            <% } %>
        }
    </script>
</head>
<body>
<div id="toast" class="toast"></div>

<h2>Add New Customer</h2>
<form action="addCustomer" method="post">
    <label for="account_no">Customer ID</label>
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
</body>
</html>
