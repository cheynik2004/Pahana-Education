package dao;

import junit.framework.TestCase;
import model.Item;

import java.util.List;

public class ItemDAOTest extends TestCase {

    private ItemDAO itemDAO;

    protected void setUp() {
        itemDAO = new ItemDAO();
    }

    protected void tearDown() {
        itemDAO = null;
    }

    public void testAddItem() {
        Item item = new Item(0, "TestItem", 99.99);
        boolean result = itemDAO.addItem(item);
        assertTrue("Item should be added", result);
    }

    public void testUpdateItemPrice() {
        // Make sure item with id=1 exists
        boolean updated = itemDAO.updateItemPrice(1, 200.0);
        assertTrue("Price should be updated", updated);
    }

    public void testDeleteItem() {
        // First insert a temporary item
        Item temp = new Item(0, "TempDelete", 10.0);
        itemDAO.addItem(temp);

        // Assume we can fetch it back (simplified, may need ID retrieval)
        List<Item> items = itemDAO.getAllItems();
        int lastId = items.get(items.size() - 1).getItemId();

        boolean deleted = itemDAO.deleteItem(lastId);
        assertTrue("Item should be deleted", deleted);
    }

    public void testGetPrice() {
        // Make sure "TestItem" exists
        double price = itemDAO.getPrice("TestItem");
        assertTrue("Price should be greater than 0", price > 0);
    }

    public void testGetAllItems() {
        List<Item> items = itemDAO.getAllItems();
        assertNotNull("Item list should not be null", items);
        assertTrue("Should return at least one item", items.size() > 0);
    }

    public void testGetItem() {
        // Make sure item with id=1 exists
        Item item = itemDAO.getItem(1);
        assertNotNull("Item with ID 1 should exist", item);
        assertEquals(1, item.getItemId());
    }
}
