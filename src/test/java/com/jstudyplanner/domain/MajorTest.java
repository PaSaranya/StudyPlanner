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
 * Test the Major domain class: constructor, getters, setters, equals.
 * @author oleg, oleglukin@yahoo.com
 */
public class MajorTest {
	
	private static Major major;
	private static Program program;
	
	/**
	 * Get major and program defined in the test-context.xml 
	 */
	@BeforeClass
	public static void setUp() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-context.xml");
		major = (Major) ctx.getBean("softwareDevelopment");
		program = (Program) ctx.getBean("bachelorOfIT");
	}
	
	@Test
	public void testSetAndGetMajorId() {
		Long id = 7l;
		assertEquals(id, major.getId());
		id++;
		major.setId(id);
		assertEquals(id, major.getId());
	}
	
	@Test
	public void testSetAndGetMajorCode() {
		String code = "SD";
		assertNotNull(major.getCode());
		assertFalse(major.getCode().equals(""));
		assertEquals(code, major.getCode());
	}
	
	@Test
	public void testSetAndGetMajorTitle() {
		String title = "Software Development";
		assertNotNull(major.getTitle());
		assertEquals(title, major.getTitle());
	}
	
	@Test
	public void testSetAndGetMajorDescription() {
		String description = "Donec et ante a dui tempus bibendum quis ac nulla. Sed id augue eu massa blandit tempor.";
		assertNotNull(major.getDescription());
		assertEquals(description, major.getDescription());
	}
	
	@Test
	public void testGetMajorDescriptionPreview() {
		String descriptionPreview = "Donec et ante a dui tempus bibendum quis ac nulla.";
		assertEquals(descriptionPreview, major.getDescriptionPreview(50));
	}
	
	@Test
	public void testSetAndGetMajorProgram() {
		Byte enabled = 1;
		assertNotNull(major.getProgram());
		assertTrue( program.equals(major.getProgram()) );
		program = new Program(1l, "code1", "title1", enabled, "description1", "undergraduate", 20, null, null);
		major.setProgram(program);
		assertTrue( program.equals(major.getProgram()) );
	}
	
	@Test
	public void testSetAndGetPrerequisites() {
		assertNotNull(major.getCompulsoryCourses());
		assertFalse(major.getCompulsoryCourses().isEmpty());
		assertTrue(major.getCompulsoryCourses().size() == 1);
		major.getCompulsoryCourses().add(new Course());
		assertTrue(major.getCompulsoryCourses().size() == 2);
		Iterator<Course> iterator = major.getCompulsoryCourses().iterator();
		boolean found = false;
		Course currentCourse;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (null != currentCourse.getCode() && currentCourse.getCode().equals("CIT2187")) {
				found = true;
			}
		}
		assertTrue(found);
	}
	
	@Test
	public void testEquals() {
		Byte enabled = 1;
		String differentDescription = "Aenean a commodo diam, sit amet consequat augue.";
		Major majorEquals = new Major(major.getId(),major.getCode(),major.getTitle(),enabled,differentDescription,null,null);
		// Even though description is different and 'compulsory courses' is null majors should be equal because they have the same id, code, title
		assertTrue(major.equals(majorEquals));
		
		// The following 3 should not be equal
		Major majorNotEquals = new Major(major.getId(),"FD",major.getTitle(),enabled,major.getDescription(),major.getProgram(),major.getCompulsoryCourses());
		assertFalse(major.equals(majorNotEquals));
		majorNotEquals = new Major(major.getId(),major.getCode(),"Web Development",enabled,major.getDescription(),major.getProgram(),major.getCompulsoryCourses());
		assertFalse(major.equals(majorNotEquals));
	}
}