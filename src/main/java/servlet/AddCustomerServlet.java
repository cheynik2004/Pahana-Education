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
        // Remove units_consumed from add customer
        int units = 0; // Default to 0 or set as needed

        Customer c = new Customer(accountNo, name, address, telephone, units);
        boolean success = new CustomerDAO().addCustomer(c);

        if (success) {
            request.setAttribute("success", "Customer added successfully!");
            request.getRequestDispatcher("addCustomer.jsp").forward(request, response);
        } else {
            response.getWriter().println("Error adding customer");
        }
    }
}


