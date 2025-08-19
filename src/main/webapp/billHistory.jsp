<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/19/2025
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.List,model.Bill" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill History</title>
    <link rel="stylesheet" type="text/css" href="CSS/billHistory.css">
</head>
<body>
<h2>Bill History</h2>

<div class="container">
    <table class="bills-table">
        <thead>
        <tr>
            <th>Bill No</th>
            <th>Customer Name</th>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Total Amount</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Bill> bills = (List<Bill>) request.getAttribute("bills");
            if (bills != null && !bills.isEmpty()) {
                for (Bill bill : bills) {
        %>
        <tr>
            <td><%= bill.getBillNo() %></td>
            <td><%= bill.getCustomerName() %></td>
            <td><%= bill.getItemName() %></td>
            <td><%= bill.getQuantity() %></td>
            <td>Rs. <%= bill.getTotalAmount() %></td>
            <td><%= bill.getGeneratedDate().toString().substring(0, 19) %></td>
            <td>
                <form action="bill" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="download">
                    <input type="hidden" name="bill_no" value="<%= bill.getBillNo() %>">
                    <input type="submit" value="Download" class="btn btn-sm btn-primary">
                </form>
            </td>
        </tr>
        <%      }
        } else {
        %>
        <tr>
            <td colspan="7" class="no-data">No bills found</td>
        </tr>
        <%  } %>
        </tbody>
    </table>

    <div class="actions">
        <a href="bill.jsp" style="text-decoration:none;">
            <input type="button" value="Generate New Bill" class="btn btn-primary">
        </a>
        <a href="dashboard.jsp" style="text-decoration:none;">
            <input type="button" value="Back to Dashboard" class="btn btn-secondary">
        </a>
    </div>
</div>
</body>
</html>

