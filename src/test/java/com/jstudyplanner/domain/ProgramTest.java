package com.jstudyplanner.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Test the Program domain class: constructor, getters, setters, equals.
 * @author oleg, oleglukin@yahoo.com
 */
public class ProgramTest {
	
	private static Program program;
	
	/**
	 * Get program defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-context.xml");
		program = (Program) ctx.getBean("bachelorOfIT");
	}
	
	@Test
	public void testSetAndGetMajorId() {
		Long id = 2l;
		assertEquals(id, program.getId());
	}
	
	@Test
	public void testSetAndGetMajorCode() {
		String code = "BIT";
		assertNotNull(program.getCode());
		assertFalse(program.getCode().equals(""));
		assertEquals(program.getCode(), code);
	}
	
	@Test
	public void testSetAndGetMajorTitle() {
		String title = "Bachelor of IT";
		assertNotNull(program.getTitle());
		assertEquals(program.getTitle(), title);
	}
	
	@Test
	public void testSetAndGetMajorDescription() {
		String description = "Pellentesque bibendum turpis turpis, sed feugiat metus feugiat in.";
		assertNotNull(program.getDescription());
		assertEquals(program.getDescription(), description);
	}
	
	@Test
	public void testGetMajorDescriptionPreview() {
		String descriptionPreview = "Pellentesque bibendum turpis turpis,";
		assertEquals(program.getDescriptionPreview(36), descriptionPreview);
	}
	
	@Test
	public void testSetAndGetCareer() {
		assertNotNull(program.getCareer());
		assertEquals(program.getCareer(), "undergraduate");
	}
	
	@Test
	public void testSetAndGetNumberOfCourses() {
		assertEquals(new Integer(18), program.getNumberOfCourses());
		program.setNumberOfCourses(24);
		assertEquals(new Integer(24), program.getNumberOfCourses());
	}
	
	@Test
	public void testSetAndGetCoreCourses() {
		assertNotNull(program.getCoreCourses());
		assertFalse(program.getCoreCourses().isEmpty());
		assertTrue(program.getCoreCourses().size() == 2);
		
		Iterator<Course> iterator = program.getCoreCourses().iterator();
		boolean found = false;
		Course currentCourse;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (currentCourse.getCode().equals("CIT651")) {
				found = true;
			}
		}
		assertTrue(found);
	}
	
	@Test
	public void testSetAndGetElectiveCourses() {
		assertNotNull(program.getElectiveCourses());
		assertFalse(program.getElectiveCourses().isEmpty());
		assertTrue(program.getElectiveCourses().size() == 1);
		
		Iterator<Course> iterator = program.getElectiveCourses().iterator();
		boolean found = false;
		Course currentCourse;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (currentCourse.getCode().equals("CIS9514")) {
				found = true;
			}
		}
		assertTrue(found);
	}
	
	@Test
	public void testEquals() {
		Byte enabled = 1;
		String differentDescription = "Aenean a commodo diam, sit amet consequat augue.";
		Program programEquals = new Program(program.getId(),program.getCode(),program.getTitle(),enabled,differentDescription,null,null,null,null);
		// Even though description is different and 'compulsory courses' is null majors should be equal because they have the same id, code, title
		assertTrue(program.equals(programEquals));
		
		// The following 3 should not be equal
		Program programNotEquals = new Program(program.getId(),"FD",program.getTitle(),enabled,program.getDescription(),program.getCareer(),24,program.getCoreCourses(),program.getElectiveCourses());
		assertFalse(program.equals(programNotEquals));
		programNotEquals = new Program(program.getId(),program.getCode(),"Web Development",enabled,program.getDescription(),program.getCareer(),24,program.getCoreCourses(),program.getElectiveCourses());
		assertFalse(program.equals(programNotEquals));
	}
}