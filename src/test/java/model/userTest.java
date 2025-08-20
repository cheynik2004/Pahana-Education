package model;

import junit.framework.TestCase;

public class userTest extends TestCase {

    private User user;

    protected void setUp() {
        user = new User();
        user.setId(100);
        user.setUsername("john_doe");
        user.setPassword("secret123");
    }

    protected void tearDown() {
        user = null;
    }

    public void testGetters() {
        assertEquals(100, user.getId());
        assertEquals("john_doe", user.getUsername());
        assertEquals("secret123", user.getPassword());
    }

    public void testSetters() {
        user.setId(200);
        user.setUsername("alice");
        user.setPassword("newpass");

        assertEquals(200, user.getId());
        assertEquals("alice", user.getUsername());
        assertEquals("newpass", user.getPassword());
    }
}
