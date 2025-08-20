package model;

import junit.framework.TestCase;

public class billTest extends TestCase {

    private Bill bill;

    protected void setUp() {
        bill = new Bill("B001", 101, "Alice", 1, "Laptop", 2, 1500.0, 3000.0);
    }

    protected void tearDown() {
        bill = null;
    }

    public void testConstructor() {
        assertEquals("B001", bill.getBillNo());
        assertEquals(101, bill.getAccountNo());
        assertEquals("Alice", bill.getCustomerName());
        assertEquals(1, bill.getItemId());
        assertEquals("Laptop", bill.getItemName());
        assertEquals(2, bill.getQuantity());
        assertEquals(1500.0, bill.getPricePerUnit(), 0.001);
        assertEquals(3000.0, bill.getTotalAmount(), 0.001);
        assertNotNull("Generated date should not be null", bill.getGeneratedDate());
    }

    public void testSetters() {
        bill.setBillId(10);
        bill.setBillNo("B002");
        bill.setAccountNo(202);
        bill.setCustomerName("Bob");
        bill.setItemId(2);
        bill.setItemName("Phone");
        bill.setQuantity(3);
        bill.setPricePerUnit(500.0);
        bill.setTotalAmount(1500.0);

        assertEquals(10, bill.getBillId());
        assertEquals("B002", bill.getBillNo());
        assertEquals(202, bill.getAccountNo());
        assertEquals("Bob", bill.getCustomerName());
        assertEquals(2, bill.getItemId());
        assertEquals("Phone", bill.getItemName());
        assertEquals(3, bill.getQuantity());
        assertEquals(500.0, bill.getPricePerUnit(), 0.001);
        assertEquals(1500.0, bill.getTotalAmount(), 0.001);
    }
}
