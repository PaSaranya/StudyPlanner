package com.jstudyplanner.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Test the Enrollment domain class: constructor, getters, setters, equals.
 * @author oleg, oleglukin@yahoo.com
 */
public class EnrollmentTest {
	
	private static Enrollment enrollment;
	private static ApplicationContext ctx;
	
	/**
	 * Get enrollment defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ctx = new ClassPathXmlApplicationContext("test-context.xml");
		enrollment = (Enrollment) ctx.getBean("enrollment1");
	}
	
	@Test
	public void testSetAndGetMajorId() {
		Long id = 1l;
		assertEquals(id, enrollment.getId());
		id++;
		enrollment.setId(id);
		assertEquals(id, enrollment.getId());
	}
	
	@Test
	public void testSetAndGetStudent() {
		Student student = (Student) ctx.getBean("student");
		assertNotNull(enrollment.getStudent());
		assertTrue(student.equals(enrollment.getStudent()));
		enrollment.setStudent(null);
		assertNull(enrollment.getStudent());
		student.setFirstName("Masha");
		enrollment.setStudent(student);
		assertEquals("Masha", enrollment.getStudent().getFirstName());
	}
	
	@Test
	public void testSetAndGetCourseAvailability() {
		CourseAvailability ca = (CourseAvailability) ctx.getBean("webDevelopment_newcastle_term1_2012");
		assertTrue(ca.equals(enrollment.getCourseAvailability()));
		enrollment.setCourseAvailability(null);
		assertNull(enrollment.getCourseAvailability());
		ca = (CourseAvailability) ctx.getBean("programmingFoundation_ipswich_term2_2012");
		enrollment.setCourseAvailability(ca);
		assertTrue(ca.equals(enrollment.getCourseAvailability()));
	}
	
	@Test
	public void testSetAndGetStatus() {
		assertEquals("planned", enrollment.getStatus());
		enrollment.setStatus("enrolled");
		assertEquals("enrolled", enrollment.getStatus());
	}
}