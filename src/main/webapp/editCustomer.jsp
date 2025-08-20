@@ -1,11 +1,3 @@
<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>


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
</head>
<body>
<div id="validation" class="validation"></div>

<h2 class="page-title">Edit Customer</h2>

<div class="container">
    <div class="form-section">
        <form action="editCustomer" method="post">
            <label>Account No:</label>
            <input type="number" name="account_no"
                   value="<%= request.getParameter("account_no") != null ? request.getParameter("account_no") : "" %>" required>
            <input type="submit" name="search" value="Search">
            <br><br>

            <label>Name:</label>
            <input type="text" name="name" value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"><br><br>

            <label>Address:</label>
            <input type="text" name="address" value="<%= request.getAttribute("address") != null ? request.getAttribute("address") : "" %>"><br><br>

            <label>Telephone:</label>
            <input type="text" name="telephone" value="<%= request.getAttribute("telephone") != null ? request.getAttribute("telephone") : "" %>"><br><br>

            <input type="submit" name="update" value="Update Customer">
            <a href="dashboard.jsp" style="text-decoration:none;">
                <input type="button" value="Go Back to Dashboard" style="margin-left:10px;">
            </a>
        </form>
        <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
        <% } %>
    </div>

    <div class="table-section">
        <h3>All Customers</h3>
        <table>
            <tr>
                <th>Account No</th>
                <th>Name</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Action</th>
            </tr>
            <% for (Customer c : customers) { %>
            <tr>
                <td><%= c.getAccountNo() %></td>
                <td><%= c.getName() %></td>
                <td><%= c.getAddress() %></td>
                <td><%= c.getTelephone() %></td>
                <td>
                    <form id="deleteForm-<%= c.getAccountNo() %>" action="editCustomer" method="post" style="display:inline;">
                        <input type="hidden" name="account_no" value="<%= c.getAccountNo() %>">
                        <input type="hidden" name="delete" value="true">
                        <button type="button" class="delete-btn" onclick="confirmDelete(<%= c.getAccountNo() %>)">Delete</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>

<script>
    function confirmDelete(accountNo) {
        if (confirm("Are you sure you want to delete this customer?")) {
            document.getElementById("deleteForm-" + accountNo).submit();
        }
    }

    function showValidation(message) {
        let validation = document.getElementById("validation");
        validation.innerText = message;
        validation.className = "validation show";
        setTimeout(function(){
            validation.className = validation.className.replace("show", "");
        }, 3000);
    }

    window.onload = function() {
        <% if (request.getAttribute("success") != null) { %>
        showValidation("<%= request.getAttribute("success") %>");
        <% } %>
    }
</script>
</body>
</html>
