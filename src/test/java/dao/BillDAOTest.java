package dao;

import junit.framework.TestCase;
import model.Bill;

import java.util.List;

public class BillDAOTest extends TestCase {

    private BillDAO billDAO;

    protected void setUp() {
        billDAO = new BillDAO();
    }

    protected void tearDown() {
        billDAO = null;
    }

    public void testSaveBill() {
        Bill bill = new Bill("B1001", 5002, "TestCustomer", 1, "TestItem", 2, 100.0, 200.0);
        boolean result = billDAO.saveBill(bill);
        assertTrue("Bill should be saved", result);
    }

    public void testGetAllBills() {
        List<Bill> bills = billDAO.getAllBills();
        assertNotNull("Bills list should not be null", bills);
        assertTrue("There should be at least one bill", bills.size() > 0);
    }

    public void testGetBillByBillNo() {
        Bill bill = billDAO.getBillByBillNo("B1001");
        assertNotNull("Bill should exist", bill);
        assertEquals("B1001", bill.getBillNo());
    }
}
