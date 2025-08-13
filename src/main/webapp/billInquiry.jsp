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

    CustomerDAO cdao = new CustomerDAO();
    ItemDAO idao = new ItemDAO();

    Customer customer = cdao.getCustomer(accountNo);
    Item item = idao.getItem(itemNo);

    double price = item.getPricePerUnit();
    double total = BillCalculator.calculateBill(quantity, price);

    // Generate a unique bill number (simple example: use current time)
    String billNo = "BILL-" + System.currentTimeMillis();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Inquiry</title>
    <link rel="stylesheet" type="text/css" href="CSS/billInquiry.css">
</head>
<body>
<h2>Bill Inquiry</h2>
<p>
    <b>Bill No:</b> <%= billNo %> &nbsp;
    <b>Customer Name:</b> <%= customer.getName() %> &nbsp;
    <b>Item Name:</b> <%= item.getName() %> &nbsp;
    <b>Quantity:</b> <%= quantity %> &nbsp;
    <b>Price:</b> Rs. <%= total %>
</p>
<a href="bill.jsp" style="text-decoration:none;">
    <input type="button" value="Back" style="margin-left:10px;">
</a>
</body>
</html>
