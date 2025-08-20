package model;

import junit.framework.TestCase;

public class customerTest extends TestCase {

    private Customer customer;

    protected void setUp() {
        customer = new Customer(101, "Alice", "123 Main St", "0771234567", 50);
    }

    protected void tearDown() {
        customer = null;
    }

    public void testConstructorWithoutUnits() {
        Customer c = new Customer(102, "Bob", "456 Street", "0712345678");
        assertEquals(102, c.getAccountNo());
        assertEquals("Bob", c.getName());
        assertEquals("456 Street", c.getAddress());
        assertEquals("0712345678", c.getTelephone());
        assertEquals(0, c.getUnitsConsumed());
    }

    public void testConstructorWithUnits() {
        assertEquals(101, customer.getAccountNo());
        assertEquals("Alice", customer.getName());
        assertEquals("123 Main St", customer.getAddress());
        assertEquals("0771234567", customer.getTelephone());
        assertEquals(50, customer.getUnitsConsumed());
    }

    public void testSetters() {
        customer.setAccountNo(200);
        customer.setName("Charlie");
        customer.setAddress("789 Road");
        customer.setTelephone("0759876543");
        customer.setUnitsConsumed(120);

        assertEquals(200, customer.getAccountNo());
        assertEquals("Charlie", customer.getName());
        assertEquals("789 Road", customer.getAddress());
        assertEquals("0759876543", customer.getTelephone());
        assertEquals(120, customer.getUnitsConsumed());
    }
}
