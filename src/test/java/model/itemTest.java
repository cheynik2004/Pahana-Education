package model;

import junit.framework.TestCase;

public class itemTest extends TestCase {

    private Item item;

    protected void setUp() {
        // This runs before each test
        item = new Item(1, "Laptop", 1500.0);
    }

    protected void tearDown() {
        // This runs after each test
        item = null;
    }

    public void testGetters() {
        assertEquals(1, item.getItemId());
        assertEquals("Laptop", item.getName());
        assertEquals(1500.0, item.getPricePerUnit(), 0.001);
    }

    public void testSetters() {
        item.setItemId(2);
        item.setName("Mouse");
        item.setPricePerUnit(25.5);

        assertEquals(2, item.getItemId());
        assertEquals("Mouse", item.getName());
        assertEquals(25.5, item.getPricePerUnit(), 0.001);
    }
}
