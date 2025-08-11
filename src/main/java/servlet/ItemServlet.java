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
        String successMsg = null;

        switch (action) {
            case "add":
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price_per_unit"));
                dao.addItem(new Item(0, name, price));
                successMsg = "Successfully added an item!";
                break;
            case "update":
                int itemId = Integer.parseInt(request.getParameter("item_id"));
                double newPrice = Double.parseDouble(request.getParameter("price_per_unit"));
                dao.updateItemPrice(itemId, newPrice);
                successMsg = "Successfully updated the item!";
                break;
            case "delete":
                int delId = Integer.parseInt(request.getParameter("item_id"));
                dao.deleteItem(delId);
                successMsg = "Item has been deleted!";
                break;
        }

        // Fetch updated item list
        request.setAttribute("items", dao.getAllItems());
        if (successMsg != null) {
            request.setAttribute("success", successMsg);
        }
        request.getRequestDispatcher("manageItems.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemDAO dao = new ItemDAO();
        request.setAttribute("items", dao.getAllItems());
        request.getRequestDispatcher("manageItems.jsp").forward(request, response);
    }
}
