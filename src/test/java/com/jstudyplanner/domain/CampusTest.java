package com.jstudyplanner.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Test the Campus domain class: constructor, getters, setters, equals.
 * @author oleg, oleglukin@yahoo.com
 */
public class CampusTest {

	private static Campus ipswich;
	private static Campus newcastle;
	private static ApplicationContext ctx;
	
	/**
	 * Get campuses defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ctx = new ClassPathXmlApplicationContext("test-context.xml");
		ipswich = (Campus) ctx.getBean("ipswich");
		newcastle = (Campus) ctx.getBean("newcastle");
	}

	@Test
	public void testSetAndGetCampusId() {
		Long id = 1l;
		assertEquals(id, ipswich.getId());
		id = 42l;
		ipswich.setId(42l);
		assertEquals(ipswich.getId(), id);
	}

	@Test
	public void testSetAndGetCampusCode() {
		String code = "IPS";
		assertNotNull(ipswich.getCode());
		assertFalse(ipswich.getCode().equals(""));
		assertEquals(ipswich.getCode(), code);
		ipswich.setCode("Code4");
		assertEquals(ipswich.getCode(), "Code4");
	}

	@Test
	public void testSetAndGetCampusTitle() {
		String title = "Ipswich";
		assertNotNull(ipswich.getTitle());
		assertEquals(ipswich.getTitle(), title);
		ipswich.setTitle("Sydney");
		assertEquals(ipswich.getTitle(), "Sydney");
	}

	@Test
	public void testSetAndGetCampusAddress() {
		String address = "199 Church St";
		assertNotNull(ipswich.getAddress());
		assertEquals(ipswich.getAddress(), address);
		ipswich.setAddress("200 Another St");
		assertEquals(ipswich.getAddress(), "200 Another St");
	}

	@Test
	public void testSetAndGetCampusPhone() {
		String phone = "+61 7 6218 9544";
		assertNotNull(ipswich.getPhone());
		assertEquals(ipswich.getPhone(), phone);
		ipswich.setPhone("753 2215 20");
		assertEquals(ipswich.getPhone(), "753 2215 20");
	}

	@Test
	public void testSetAndGetCampusDescription() {
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ut velit eu metus aliquam adipiscing. Sed eleifend gravida urna, sit amet hendrerit augue condimentum venenatis. In eget cursus lectus, vitae porttitor est. Nam suscipit elit ac nisl euismod pellentesque. Vivamus id pretium dolor, non fermentum nisl. In eget eros dictum, posuere odio vitae, vestibulum lectus. Donec porta aliquam mauris.";
		assertNotNull(ipswich.getDescription());
		assertEquals(ipswich.getDescription(), description);
		ipswich.setDescription("no description available");
		assertEquals(ipswich.getDescription(), "no description available");
	}
	
	@Test
	public void testGetCampusDescriptionPreview() {
		String descriptionPreview = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
		assertEquals(ipswich.getDescriptionPreview(56), descriptionPreview);
	}
	
	@Test
	public void testEquals() {
		Byte enabled = 1;
		String differentAddress = "199 Denwer Rd";
		String differentPhone = "762189544";
		String differentDescription = "Lorel impsu, and consectetur.";
		Campus campusEquals = new Campus(newcastle.getId(), newcastle.getCode(), newcastle.getTitle(), enabled, differentAddress,differentPhone,differentDescription);
		// Even though address, phone and description are different campuses should be equal because they have the same id, code, title
		assertTrue(newcastle.equals(campusEquals));
		
		// The following 3 should not be equal
		Campus campusNotEquals = new Campus(newcastle.getId(), "BNE",newcastle.getTitle(), enabled, newcastle.getAddress(), newcastle.getPhone(), newcastle.getDescription());
		assertFalse(newcastle.equals(campusNotEquals));
		campusNotEquals = new Campus(newcastle.getId(), newcastle.getCode(), "Test Campus Title", enabled, newcastle.getAddress(), newcastle.getPhone(), newcastle.getDescription());
		assertFalse(newcastle.equals(campusNotEquals));
	}
	
	// TODO test enabled
}