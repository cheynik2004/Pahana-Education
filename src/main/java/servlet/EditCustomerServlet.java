package servlet;

import dao.CustomerDAO;
import model.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EditCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int accountNo = Integer.parseInt(request.getParameter("account_no"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        int units = Integer.parseInt(request.getParameter("units_consumed"));

        Customer c = new Customer(accountNo, name, address, telephone, units);
        boolean success = new CustomerDAO().updateCustomer(c);

        if (success) {
            response.sendRedirect("dashboard.jsp");
        } else {
            response.getWriter().println("Error updating customer");
        }
    }
}
