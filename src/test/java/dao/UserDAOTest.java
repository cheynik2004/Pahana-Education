package dao;

import junit.framework.TestCase;
import model.User;

public class UserDAOTest extends TestCase {

    private UserDAO userDAO;

    protected void setUp() {
        userDAO = new UserDAO();
    }

    protected void tearDown() {
        userDAO = null;
    }

    public void testValidateUserSuccess() {
        // Make sure a user with username "john" and password "pass123" exists in DB
        User u = userDAO.validateUser("john", "pass123");
        assertNotNull("User should be validated", u);
        assertEquals("john", u.getUsername());
    }

    public void testValidateUserFailure() {
        User u = userDAO.validateUser("wronguser", "wrongpass");
        assertNull("Invalid credentials should return null", u);
    }
}
