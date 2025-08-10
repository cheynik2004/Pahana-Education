package servlet;

import dao.CustomerDAO;
import dao.ItemDAO;
import util.BillCalculator;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int accountNo = Integer.parseInt(request.getParameter("account_no"));
        String itemName = request.getParameter("item_name");

        int units = new CustomerDAO().getUnitsConsumed(accountNo);
        double price = new ItemDAO().getPrice(itemName);

        double total = BillCalculator.calculateBill(units, price);

        request.setAttribute("billDetails", "Account No: " + accountNo + ", Item: " + itemName +
                ", Units: " + units + ", Price per unit: " + price + ", Total: Rs. " + total);
        request.getRequestDispatcher("bill.jsp").forward(request, response);
    }
}
