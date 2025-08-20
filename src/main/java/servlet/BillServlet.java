package servlet;

import dao.CustomerDAO;
import dao.ItemDAO;
import dao.BillDAO;
import model.Customer;
import model.Item;
import model.Bill;
import util.BillCalculator;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("download".equals(action)) {
            downloadBill(request, response);
            return;
        }

        try {
            int accountNo = Integer.parseInt(request.getParameter("account_no"));
            int itemNo = Integer.parseInt(request.getParameter("item_no"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            CustomerDAO cdao = new CustomerDAO();
            ItemDAO idao = new ItemDAO();
            BillDAO bdao = new BillDAO();

            Customer customer = cdao.getCustomer(accountNo);
            Item item = idao.getItem(itemNo);

            if (customer == null || item == null) {
                request.setAttribute("error", "Customer or Item not found.");
                loadBillData(request);
                request.getRequestDispatcher("bill.jsp").forward(request, response);
                return;
            }

            double price = item.getPricePerUnit();
            double total = BillCalculator.calculateBill(quantity, price);
            String billNo = "BILL-" + System.currentTimeMillis();


            Bill bill = new Bill(billNo, accountNo, customer.getName(), itemNo,
                    item.getName(), quantity, price, total);

            boolean saved = bdao.saveBill(bill);

            if (saved) {

                response.sendRedirect("billInquiry.jsp?account_no=" + accountNo +
                        "&item_no=" + itemNo + "&quantity=" + quantity +
                        "&bill_no=" + billNo);
            } else {
                request.setAttribute("error", "Error saving bill to database.");
                loadBillData(request);
                request.getRequestDispatcher("bill.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input values.");
            loadBillData(request);
            request.getRequestDispatcher("bill.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error generating bill.");
            loadBillData(request);
            request.getRequestDispatcher("bill.jsp").forward(request, response);
        }
    }

    private void downloadBill(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String billNo = request.getParameter("bill_no");
        BillDAO bdao = new BillDAO();
        Bill bill = bdao.getBillByBillNo(billNo);

        if (bill != null) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + billNo + ".txt\"");

            StringBuilder billContent = new StringBuilder();
            billContent.append("=================================\n");
            billContent.append("     PAHANA EDU BILLING SYSTEM   \n");
            billContent.append("=================================\n\n");
            billContent.append("Bill No: ").append(bill.getBillNo()).append("\n");
            billContent.append("Date: ").append(bill.getGeneratedDate().toString()).append("\n\n");
            billContent.append("Customer Details:\n");
            billContent.append("Account No: ").append(bill.getAccountNo()).append("\n");
            billContent.append("Name: ").append(bill.getCustomerName()).append("\n\n");
            billContent.append("Item Details:\n");
            billContent.append("Item: ").append(bill.getItemName()).append("\n");
            billContent.append("Quantity: ").append(bill.getQuantity()).append("\n");
            billContent.append("Price per Unit: Rs. ").append(bill.getPricePerUnit()).append("\n");
            billContent.append("Total Amount: Rs. ").append(bill.getTotalAmount()).append("\n\n");
            billContent.append("=================================\n");
            billContent.append("Thank you for your business!\n");
            billContent.append("=================================\n");

            response.getWriter().write(billContent.toString());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Bill not found");
        }
    }

    private void loadBillData(HttpServletRequest request) {
        CustomerDAO cdao = new CustomerDAO();
        ItemDAO idao = new ItemDAO();
        request.setAttribute("customers", cdao.getAllCustomers());
        request.setAttribute("items", idao.getAllItems());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loadBillData(request);
        request.getRequestDispatcher("bill.jsp").forward(request, response);
    }
}
