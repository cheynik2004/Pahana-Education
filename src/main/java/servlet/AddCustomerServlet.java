package servlet;

import dao.CustomerDAO;
import model.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int accountNo = Integer.parseInt(request.getParameter("account_no"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");

        int units = 0;

        Customer c = new Customer(accountNo, name, address, telephone, units);
        boolean success = new CustomerDAO().addCustomer(c);

        if (success) {
            request.setAttribute("success", "Customer added successfully!");
        } else {
            request.setAttribute("error", "Customer ID already exists!");
        }

        request.getRequestDispatcher("addCustomer.jsp").forward(request, response);
    }
}
