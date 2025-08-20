package dao;

import junit.framework.TestCase;
import model.Customer;

import java.util.List;

public class CustomerDAOTest extends TestCase {

    private CustomerDAO customerDAO;

    protected void setUp() {
        customerDAO = new CustomerDAO();
    }

    protected void tearDown() {
        customerDAO = null;
    }

    public void testAddCustomer() {
        Customer c = new Customer(5001, "TestUser", "Colombo", "0771112222", 100);
        boolean result = customerDAO.addCustomer(c);
        assertTrue("Customer should be added", result);
    }

    public void testUpdateCustomer() {
        Customer c = new Customer(5001, "UpdatedUser", "Kandy", "0773334444", 200);
        boolean updated = customerDAO.updateCustomer(c);
        assertTrue("Customer should be updated", updated);
    }

    public void testGetCustomer() {
        Customer c = customerDAO.getCustomer(5001);
        assertNotNull("Customer should exist", c);
        assertEquals(5001, c.getAccountNo());
    }

    public void testGetUnitsConsumed() {
        int units = customerDAO.getUnitsConsumed(5001);
        assertTrue("Units should be >= 0", units >= 0);
    }

    public void testGetAllCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        assertNotNull(customers);
        assertTrue("There should be at least one customer", customers.size() > 0);
    }

    public void testDeleteCustomer() {
        boolean deleted = customerDAO.deleteCustomer(5001);
        assertTrue("Customer should be deleted", deleted);
    }
}
