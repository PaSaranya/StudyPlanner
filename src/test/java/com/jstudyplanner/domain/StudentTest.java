package com.jstudyplanner.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Test the Student domain class. It doesn't test superclass' (User) methods.
 * @author oleg, oleglukin@yahoo.com
 */
public class StudentTest {
	
	private static Student student;
	private static ApplicationContext ctx;
	
	/**
	 * Get student defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ctx = new ClassPathXmlApplicationContext("test-context.xml");
		student = (Student) ctx.getBean("student");
	}
	
	@Test
	public void testSetAndGetType() {
		assertEquals("domestic", student.getType());
		student.setType("international");
		assertEquals("international", student.getType());
	}
	
	@Test
	public void testSetAndGetMajor() {
		Major major = (Major) ctx.getBean("softwareDevelopment");
		assertTrue(major.equals(student.getMajor()));
		major = (Major) ctx.getBean("informationSystems");
		student.setMajor(major);
		assertNotNull(student.getMajor());
		assertTrue(major.equals(student.getMajor()));
	}
	
	@Test
	public void testSetAndGetCampus() {
		Campus campus = (Campus) ctx.getBean("ipswich");
		assertTrue(campus.equals(student.getCampus()));
		campus = (Campus) ctx.getBean("newcastle");
		student.setCampus(campus);
		assertNotNull(student.getCampus());
		assertTrue(campus.equals(student.getCampus()));
	}
}