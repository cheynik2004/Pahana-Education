package servlet;

import dao.ItemDAO;
import model.Item;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ItemDAO dao = new ItemDAO();

        switch (action) {
            case "add":
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price_per_unit"));
                dao.addItem(new Item(0, name, price));
                break;
            case "update":
                int itemId = Integer.parseInt(request.getParameter("item_id"));
                double newPrice = Double.parseDouble(request.getParameter("price_per_unit"));
                dao.updateItemPrice(itemId, newPrice);
                break;
            case "delete":
                int delId = Integer.parseInt(request.getParameter("item_id"));
                dao.deleteItem(delId);
                break;
        }
        response.sendRedirect("dashboard.jsp");
    }
}
