package com.jstudyplanner.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Test the Admin domain class. As admin doesn't have any specific attributes and methods
 * it tests superclass' (User) methods.
 * @author oleg, oleglukin@yahoo.com
 */
public class AdminTest {
	
	private static Admin admin;
	
	/**
	 * Get admin defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-context.xml");
		admin = (Admin) ctx.getBean("admin");
	}
	
	@Test
	public void testSetAndGetUserId() {
		Long id = 2l;
		assertEquals(id, admin.getId());
		id = 42l;
		admin.setId(42l);
		assertEquals(id, admin.getId());
	}
	
	@Test
	public void testSetAndGetEmail() {
		String email = "test.admin@jstudyplanner.com";
		assertEquals(email, admin.getEmail());
		email = "admin2@jstudyplanner.com";
		admin.setEmail("admin2@jstudyplanner.com");
		assertEquals(email, admin.getEmail());
	}
	
	@Test
	public void testSetAndGetUsername() {
		String username = "test.admin";
		admin.setUsername("test.admin");
		assertEquals(username, admin.getUsername());
		admin.setUsername("admin2");
		assertFalse( "test.admin".equals( admin.getUsername() ) );
	}
	
	@Test
	public void testSetAndGetPassword() {
		String password = "admin1!";
		assertEquals(password, admin.getPassword());
		password = "admin1!@";
		admin.setPassword("admin1!@");
		assertEquals(password, admin.getPassword());
	}
	
	@Test
	public void testSetAndGetEnabled() {
		Byte enabled = 1;
		assertEquals(enabled, admin.getEnabled());
		enabled = 0;
		admin.setEnabled(enabled);
		assertEquals(enabled, admin.getEnabled());
	}
	
	@Test
	public void testSetAndGetFirstName() {
		String firstName = "Rob";
		assertEquals(firstName, admin.getFirstName());
		firstName = "Robin";
		admin.setFirstName("Robin");
		assertEquals(firstName, admin.getFirstName());
	}
	
	@Test
	public void testSetAndGetLastName() {
		String lastName = "Smith";
		assertEquals(lastName, admin.getLastName());
		lastName = "Anderson";
		admin.setLastName("Anderson");
		assertEquals(lastName, admin.getLastName());
	}
	
	@Test
	public void testSetAndGetPhone() {
		String phone = "748951324";
		assertEquals(phone, admin.getPhone());
		phone = "748 951 324";
		admin.setPhone("748 951 324");
		assertEquals(phone, admin.getPhone());
	}
	
	@Test
	public void testEquals() {
		admin.setUsername("myAdmin");
		Admin adminToCompare = new Admin(42l, "admin", null, "myAdmin", null, null, null, null, null);
		assertTrue(admin.equals(adminToCompare));
		admin.setUsername("myadmin"); // username is not case sensitive
		assertTrue(admin.equals(adminToCompare));
		admin.setUsername("anotherUsername");
		assertFalse(admin.equals(adminToCompare));
	}
}