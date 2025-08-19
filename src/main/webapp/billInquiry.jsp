<%--
  Created by IntelliJ IDEA.
  User: ASUS Vivobook
  Date: 8/10/2025
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="dao.CustomerDAO,dao.ItemDAO,model.Customer,model.Item,util.BillCalculator" %>
<%
    int accountNo = Integer.parseInt(request.getParameter("account_no"));
    int itemNo = Integer.parseInt(request.getParameter("item_no"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String billNo = request.getParameter("bill_no");

    CustomerDAO cdao = new CustomerDAO();
    ItemDAO idao = new ItemDAO();

    Customer customer = cdao.getCustomer(accountNo);
    Item item = idao.getItem(itemNo);

    double price = item.getPricePerUnit();
    double total = BillCalculator.calculateBill(quantity, price);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Inquiry</title>
    <link rel="stylesheet" type="text/css" href="CSS/billInquiry.css">
</head>
<body>
<h2>Bill Generated Successfully</h2>
<div class="bill-container">
    <div class="bill-header">
        <h3>PAHANA EDU BILLING SYSTEM</h3>
        <p><b>Bill No:</b> <%= billNo %></p>
        <p><b>Date:</b> <%= new java.util.Date() %></p>
    </div>

    <div class="bill-details">
        <h4>Customer Details:</h4>
        <p><b>Account No:</b> <%= accountNo %></p>
        <p><b>Customer Name:</b> <%= customer.getName() %></p>
        <p><b>Address:</b> <%= customer.getAddress() %></p>
        <p><b>Telephone:</b> <%= customer.getTelephone() %></p>

        <h4>Item Details:</h4>
        <p><b>Item Name:</b> <%= item.getName() %></p>
        <p><b>Quantity:</b> <%= quantity %></p>
        <p><b>Price per Unit:</b> Rs. <%= price %></p>
        <p><b>Total Amount:</b> Rs. <%= total %></p>
    </div>

    <div class="bill-actions">
        <form action="bill" method="post" style="display:inline;">
            <input type="hidden" name="action" value="download">
            <input type="hidden" name="bill_no" value="<%= billNo %>">
            <input type="submit" value="Download Bill" class="btn btn-primary">
        </form>

        <a href="bill.jsp" style="text-decoration:none;">
            <input type="button" value="Generate Another Bill" class="btn btn-secondary">
        </a>

        <a href="billHistory" style="text-decoration:none;">
            <input type="button" value="View Bill History" class="btn btn-info">
        </a>

        <a href="dashboard.jsp" style="text-decoration:none;">
            <input type="button" value="Back to Dashboard" class="btn btn-secondary">
        </a>
    </div>
</div>
</body>
</html>
