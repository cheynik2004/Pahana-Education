package servlet;

import dao.BillDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BillHistoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BillDAO bdao = new BillDAO();
        request.setAttribute("bills", bdao.getAllBills());
        request.getRequestDispatcher("billHistory.jsp").forward(request, response);
    }
}
