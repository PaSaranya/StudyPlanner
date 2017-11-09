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
 * Test the Course domain class: constructor, getters, setters, equals.
 * @author oleg, oleglukin@yahoo.com
 */
public class CourseTest {
	
	private static Course course;
	
	/**
	 * Get course defined in the test-context.xml
	 */
	@BeforeClass
	public static void setUp() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-context.xml");
		course = (Course) ctx.getBean("enterpriseSystems");
	}
	
	@Test
	public void testSetAndGetCourseId() {
		Long id = 1l;
		assertEquals(id, course.getId());
	}
	
	@Test
	public void testSetAndGetCourseCode() {
		String code = "CIT2947";
		assertNotNull(course.getCode());
		assertFalse(course.getCode().equals(""));
		assertEquals(course.getCode(), code);
	}
	
	@Test
	public void testSetAndGetCourseTitle() {
		String title = "Enterprise Systems";
		assertNotNull(course.getTitle());
		assertEquals(course.getTitle(), title);
	}
	
	@Test
	public void testSetAndGetCourseDescription() {
		String description = "Nunc quis mauris viverra, scelerisque mauris vel, convallis ante. Curabitur tempus lacus diam. Duis viverra tempor lorem nec venenatis. Nunc ut fermentum libero, ut fermentum nibh. Proin ac ullamcorper justo. Praesent urna lacus, mattis ut massa ac, eleifend bibendum leo. Nunc fermentum aliquam mollis.";
		course.setDescription(description);
		assertNotNull(course.getDescription());
		assertEquals(course.getDescription(), description);
	}
	
	@Test
	public void testGetCourseDescriptionPreview() {
		String description = "Nunc quis mauris viverra, scelerisque mauris vel, convallis ante. Curabitur tempus lacus diam. Duis viverra tempor lorem nec venenatis. Nunc ut fermentum libero, ut fermentum nibh. Proin ac ullamcorper justo. Praesent urna lacus, mattis ut massa ac, eleifend bibendum leo. Nunc fermentum aliquam mollis.";
		String descriptionPreview = "Nunc quis mauris viverra, scelerisque mauris vel, con";
		assertEquals(course.getDescriptionPreview(53), descriptionPreview);
		assertEquals(course.getDescriptionPreview(9999), description);
		course.setDescription("abcd");
		assertEquals(course.getDescriptionPreview(3), "abc");
		assertEquals(course.getDescriptionPreview(4), "abcd");
		assertEquals(course.getDescriptionPreview(5), "abcd");
	}
	
	@Test
	public void testSetAndGetPrerequisites() {
		assertNotNull(course.getPrerequisites());
		assertFalse(course.getPrerequisites().isEmpty());
		assertTrue(course.getPrerequisites().size() == 2);
		course.getPrerequisites().add(new Course());
		assertTrue(course.getPrerequisites().size() == 3);
		
		Iterator<Course> iterator = course.getPrerequisites().iterator();
		boolean found = false;
		Course currentCourse;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (null != currentCourse.getCode() && currentCourse.getCode().equals("CIT651")) {
				found = true;
			}
		}
		assertTrue(found);
	}
	
	@Test
	public void testEquals() {
		Byte enabled = 1;
		String differentDescription = "Aenean a commodo diam, sit amet consequat augue.";
		Course courseEquals = new Course(course.getId(),course.getCode(),course.getTitle(),enabled,differentDescription,null);
		// Even though description is different and prerequisites is null courses should be equal because they have the same id, code, title
		assertTrue(course.equals(courseEquals));
		
		// The following 3 should not be equal
		Course courseNotEquals = new Course(course.getId(),"BNE",course.getTitle(),enabled,course.getDescription(),null);
		assertFalse(course.equals(courseNotEquals));
		courseNotEquals = new Course(course.getId(),course.getCode(),"Test Course Title",enabled,course.getDescription(),null);
		assertFalse(course.equals(courseNotEquals));
	}
}