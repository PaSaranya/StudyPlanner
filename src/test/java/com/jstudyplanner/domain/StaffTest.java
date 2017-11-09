package com.jstudyplanner.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Test the Staff domain class. It doesn't test superclass' (User) methods.
 * @author oleg, oleglukin@yahoo.com
 */
public class StaffTest {
	
	private static Staff staff;
	private static ApplicationContext ctx;
	
	/**
	 * Get staff defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ctx = new ClassPathXmlApplicationContext("test-context.xml");
		staff = (Staff) ctx.getBean("staff");
	}
	
	@Test
	public void testSetAndGetManagedCampuses() {
		assertNotNull(staff.getManagedCampuses());
		assertTrue(staff.getManagedCampuses().size() == 1);
		Campus ipswich = (Campus) ctx.getBean("ipswich");
		Campus newcastle = (Campus) ctx.getBean("newcastle");
		assertTrue(staff.getManagedCampuses().contains(ipswich));
		Set<Campus> campuses = staff.getManagedCampuses();
		campuses.remove(ipswich);
		campuses.add(newcastle);
		staff.setManagedCampuses(campuses);
		assertEquals(campuses, staff.getManagedCampuses());
	}
}