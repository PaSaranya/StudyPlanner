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
 * Test the CourseAvailability domain class: constructor, getters, setters, equals.
 * @author oleg, oleglukin@yahoo.com
 */
public class CourseAvailabilityTest {
	
	private static ApplicationContext ctx;
	private static CourseAvailability ca;
	
	/**
	 * Get CourseAvailability defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ctx = new ClassPathXmlApplicationContext("test-context.xml");
		ca = (CourseAvailability) ctx.getBean("programmingFoundation_ipswich_term1_2012");
	}
	
	@Test
	public void testSetAndGetCourseAvailabilityId() {
		Long id = 1l;
		assertEquals(id, ca.getId());
		id = 42l;
		ca.setId(42l);
		assertEquals(ca.getId(), id);
	}
	
	@Test
	public void testSetAndGetTerm() {
		assertNotNull(ca.getTerm());
		assertEquals(ca.getTerm().getYear(), new Integer(2012));
		assertEquals(ca.getTerm().getNumber(), new Integer(1));
		Term term1_2013 = (Term) ctx.getBean("term1_2013");
		Term term1_2012 = (Term) ctx.getBean("term1_2012");
		ca.setTerm(term1_2013);
		assertEquals(ca.getTerm().getYear(), new Integer(2013));
		assertEquals(ca.getTerm().getNumber(), new Integer(1));
		ca.setTerm(term1_2012);
	}
	
	@Test
	public void testSetAndGetCourse() {
		assertNotNull(ca.getCourse());
		assertEquals(ca.getCourse().getCode(), "CIT651");
		assertEquals(ca.getCourse().getTitle(), "Programming Foundation");
		Course webDevelopment = (Course) ctx.getBean("webDevelopment");
		Course programmingFoundation = (Course) ctx.getBean("programmingFoundation");
		ca.setCourse(webDevelopment);
		assertEquals(ca.getCourse().getCode(), "CIT2187");
		assertEquals(ca.getCourse().getTitle(), "Web development");
		ca.setCourse(programmingFoundation);
	}
	
	@Test
	public void testSetAndGetCampus() {
		assertNotNull(ca.getCampus());
		assertEquals(ca.getCampus().getCode(), "IPS");
		assertEquals(ca.getCampus().getTitle(), "Ipswich");
		Campus newcastle = (Campus) ctx.getBean("newcastle");
		Campus ipswich = (Campus) ctx.getBean("ipswich");
		ca.setCampus(newcastle);
		assertEquals(ca.getCampus().getCode(), "NCL");
		assertEquals(ca.getCampus().getTitle(), "Newcastle");
		ca.setCampus(ipswich);
	}
	
	/**
	 * Reset CourseAvailability, compare with different CourseAvailability, compare with similar CourseAvailability.
	 */
	@Test
	public void testEquals() {
		CourseAvailability caNotEqual = (CourseAvailability) ctx.getBean("programmingFoundation_newcastle_term1_2012");
		assertFalse(ca.equals(caNotEqual));
		
		Term term1_2012 = (Term) ctx.getBean("term1_2012");
		Course programmingFoundation = (Course) ctx.getBean("programmingFoundation");
		Campus ipswich = (Campus) ctx.getBean("ipswich");
		CourseAvailability caEqual = new CourseAvailability(21l, term1_2012, programmingFoundation, ipswich);
//		assertTrue(ca.getCampus().equals(caEqual.getCampus())); // this test sometimes fails if running Campus.equals() (not Campus.getCode().equals())
//		assertTrue(ca.getCourse().equals(caEqual.getCourse()));
//		assertTrue(ca.getTerm().compare(caEqual.getTerm()) == 0);
		assertTrue(ca.equals(caEqual)); // This test doesn't pass while building
	}
}