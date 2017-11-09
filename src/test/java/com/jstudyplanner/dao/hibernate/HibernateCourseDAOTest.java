package com.jstudyplanner.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstudyplanner.dao.CourseDAO;
import com.jstudyplanner.domain.Course;

public class HibernateCourseDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateCampusDAOTest.class);
	private static CourseDAO courseDAO;
	private static ApplicationContext beansCtx;
	
	@BeforeClass
	public static void setUp() {
		beansCtx = new ClassPathXmlApplicationContext("test-context.xml");
		courseDAO = (CourseDAO) beansCtx.getBean("courseDAO");
	}
	
	/**
	 * This method tests all CRUD operations
	 * DAO should not add object with defined id because id should be assigned
	 * by the database (auto-increment).
	 * This test persists course object into the database, retrieves it back, compares,
	 * deletes it from the database and checks the result. Also checks prerequisites.
	 * Methods tested:
	 * add(Course)
	 * save(Course)
	 * delete(Course)
	 * delete(Long)
	 * getCourseById(Long)
	 * getCourseByCode(String)
	 */
	@Test
	public void testCRUDCourse() {
		Course programmingFoundation = (Course) beansCtx.getBean("programmingFoundation");
		Course webDevelopment = (Course) beansCtx.getBean("webDevelopment");
		Course enterpriseSystems = (Course) beansCtx.getBean("enterpriseSystems");
		try {
			courseDAO.add(programmingFoundation);
			fail();
		} catch (RuntimeException ex) {
			logger.info("courseDAO should not persist course with id");
		}
		
		// Test create (add) including many-to-many (prerequisites), read (get*)
		courseDAO.delete(1l);
		programmingFoundation.setId(null);
		webDevelopment.setId(null);
		enterpriseSystems.setId(null);
		courseDAO.add(programmingFoundation);
		courseDAO.add(webDevelopment);
		courseDAO.add(enterpriseSystems);
		
		assertTrue(courseDAO.countAll() == 3);
		Course enterpriseSystemsFromDB = courseDAO.getCourseByCode("CIT2947");
		assertNotNull(enterpriseSystemsFromDB);
		assertTrue(enterpriseSystems.getCode().equals(enterpriseSystemsFromDB.getCode()));
		assertTrue(enterpriseSystemsFromDB.getPrerequisites().size() == 2);
		Iterator<Course> iterator = enterpriseSystemsFromDB.getPrerequisites().iterator();
		boolean webDevelopmentFound = false;
		boolean programmingFoundationFound = false;
		Course currentCourse;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (currentCourse.equals(webDevelopment)) {
				webDevelopmentFound = true;
			}
			if (currentCourse.equals(programmingFoundation)) {
				programmingFoundationFound = true;
			}
		}
		assertTrue(webDevelopmentFound);
		assertTrue(programmingFoundationFound);
		
		enterpriseSystemsFromDB = courseDAO.getCourseById(enterpriseSystemsFromDB.getId());
		assertNotNull(enterpriseSystemsFromDB);
		
		// Test update (save)
		enterpriseSystems.setCode("newCode");
		courseDAO.save(enterpriseSystems);
		enterpriseSystemsFromDB = courseDAO.getCourseByCode("newCode");
		assertNotNull(enterpriseSystemsFromDB);
		assertTrue(enterpriseSystemsFromDB.equals(enterpriseSystems));
		
		// Test delete
		courseDAO.delete(enterpriseSystems);
		courseDAO.delete(webDevelopment);
		courseDAO.delete(programmingFoundation);
		assertNull(courseDAO.getCourseByCode("newCode"));
		assertNull(courseDAO.getCourseByCode("CIT651"));
		assertNull(courseDAO.getCourseByCode("CIT2187"));
	}
}