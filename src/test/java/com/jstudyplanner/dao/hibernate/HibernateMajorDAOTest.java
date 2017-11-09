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
import com.jstudyplanner.dao.MajorDAO;
import com.jstudyplanner.dao.ProgramDAO;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Program;

public class HibernateMajorDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateCampusDAOTest.class);
	private static MajorDAO majorDAO;
	private static ApplicationContext beansCtx;
	
	@BeforeClass
	public static void setUp() {
		beansCtx = new ClassPathXmlApplicationContext("test-context.xml");
		majorDAO = (MajorDAO) beansCtx.getBean("majorDAO");
	}
	
	/**
	 * This method tests all CRUD operations
	 * DAO should not add object with defined id because id should be assigned
	 * by the database (auto-increment).
	 * This test persists major object into the database, retrieves it back, compares,
	 * deletes it from the database and checks the result. Also checks relationships with
	 * course: compulsoryCourses.
	 * Methods tested:
	 * add(Major)
	 * save(Major)
	 * delete(Major)
	 * delete(Long)
	 * getMajorById(Long)
	 * getMajorByCode(String)
	 */
	@Test
	public void testCRUDMajor() {
		Course webDevelopment = (Course) beansCtx.getBean("webDevelopment");
		Byte enabled = 1;
		Program program = new Program(null, "code1", "title1", enabled, "description1", "undergraduate", 20, null, null);
		Major major = (Major) beansCtx.getBean("softwareDevelopment");
		CourseDAO courseDAO = (CourseDAO) beansCtx.getBean("courseDAO");
		ProgramDAO programDAO = (ProgramDAO) beansCtx.getBean("programDAO");
		
		webDevelopment.setId(null);
		courseDAO.add(webDevelopment);
		
		program.setId(null);
		programDAO.add(program);
		major.setProgram(program);
		
		try {
			majorDAO.add(major);
			fail();
		} catch (RuntimeException ex) {
			logger.info("majorDAO should not persist major with defined id");
		}
		
		// Test create (add) including many-to-many (compulsoryCourses), read (get*)
		major.setId(null);
		majorDAO.add(major);
		assertTrue(majorDAO.countAll() == 1);
		Major majorFromDB = majorDAO.getMajorByCode(major.getCode());
		assertNotNull(majorFromDB);
		assertTrue( majorFromDB.equals(major) );
		assertTrue( majorFromDB.getProgram().equals(program) );
		assertTrue( majorFromDB.getCompulsoryCourses().size() == 1 );
		Iterator<Course> iterator = majorFromDB.getCompulsoryCourses().iterator();
		boolean found = false;
		Course currentCourse;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (currentCourse.equals(webDevelopment)) {
				found = true;
			}
		}
		assertTrue(found);
		
		majorFromDB = majorDAO.getMajorById(majorFromDB.getId());
		assertNotNull(majorFromDB);
		
		// Test update (save)
		major.setCode("SWDev");
		majorDAO.save(major);
		majorFromDB = majorDAO.getMajorByCode(major.getCode());
		assertNotNull(majorFromDB);
		assertTrue(majorFromDB.equals(major));
		
		// Test delete
		majorDAO.delete(major);
		courseDAO.delete(webDevelopment);
		programDAO.delete(program);
		assertNull(courseDAO.getCourseByCode(webDevelopment.getCode()));
		assertTrue(programDAO.countAll() == 0);
		assertNull(majorDAO.getMajorByCode(major.getCode()));
	}
}