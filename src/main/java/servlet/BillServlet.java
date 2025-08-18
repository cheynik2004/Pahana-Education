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

        try {
            int accountNo = Integer.parseInt(request.getParameter("account_no"));
            int itemNo = Integer.parseInt(request.getParameter("item_no"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            CustomerDAO cdao = new CustomerDAO();
            ItemDAO idao = new ItemDAO();

            double price = idao.getItem(itemNo).getPricePerUnit();
            double total = BillCalculator.calculateBill(quantity, price);

            request.setAttribute("success", "Bill generated: Rs. " + total);
            request.setAttribute("customers", cdao.getAllCustomers());
            request.setAttribute("items", idao.getAllItems());

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input values.");
        } catch (Exception e) {
            request.setAttribute("error", "Error generating bill.");
        }

        request.getRequestDispatcher("bill.jsp").forward(request, response);
    }
}
