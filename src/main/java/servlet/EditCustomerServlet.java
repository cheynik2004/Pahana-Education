package servlet;

import dao.CustomerDAO;
import model.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EditCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("search") != null ? "search" :
                request.getParameter("update") != null ? "update" :
                        request.getParameter("delete") != null ? "delete" : "";

        String accountNoStr = request.getParameter("account_no");

        if (accountNoStr == null || accountNoStr.trim().isEmpty()) {
            request.setAttribute("error", "Account No is required.");
            request.getRequestDispatcher("editCustomer.jsp").forward(request, response);
            return;
        }

        int accountNo;
        try {
            accountNo = Integer.parseInt(accountNoStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid Account No.");
            request.getRequestDispatcher("editCustomer.jsp").forward(request, response);
            return;
        }

        CustomerDAO dao = new CustomerDAO();

        switch (action) {
            case "search":
                Customer customer = dao.getCustomer(accountNo);
                request.setAttribute("selectedCustomer", customer);
                if (customer != null) {
                    request.setAttribute("name", customer.getName());
                    request.setAttribute("address", customer.getAddress());
                    request.setAttribute("telephone", customer.getTelephone());
                } else {
                    request.setAttribute("error", "Customer not found.");
                }
                break;

            case "update":
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String telephone = request.getParameter("telephone");

                Customer existing = dao.getCustomer(accountNo);
                int units = existing != null ? existing.getUnitsConsumed() : 0;

                Customer c = new Customer(accountNo, name, address, telephone, units);
                boolean success = dao.updateCustomer(c);

                request.setAttribute("selectedCustomer", c);
                if (success) {
                    request.setAttribute("success", "Customer updated successfully!");
                } else {
                    request.setAttribute("error", "Error updating customer");
                }
                break;

            case "delete":
                boolean deleted = dao.deleteCustomer(accountNo);
                if (deleted) {
                    request.setAttribute("success", "Customer deleted successfully!");
                } else {
                    request.setAttribute("error", "Error deleting customer");
                }
                break;
        }

        request.getRequestDispatcher("editCustomer.jsp").forward(request, response);
    }
}
