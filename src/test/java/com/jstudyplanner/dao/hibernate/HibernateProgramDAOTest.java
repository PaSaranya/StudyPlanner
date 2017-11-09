package com.jstudyplanner.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

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


public class HibernateProgramDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateCampusDAOTest.class);
	private static ProgramDAO programDAO;
	private static ApplicationContext beansCtx;
	
	@BeforeClass
	public static void setUp() {
		beansCtx = new ClassPathXmlApplicationContext("test-context.xml");
		programDAO = (ProgramDAO) beansCtx.getBean("programDAO");
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
	public void testCRUDProgram() {
		Course programmingFoundation = (Course) beansCtx.getBean("programmingFoundation");
		Course databaseDevelopment = (Course) beansCtx.getBean("databaseDevelopment");
		Course businessAnalysis = (Course) beansCtx.getBean("businessAnalysis");
		Program program = (Program) beansCtx.getBean("bachelorOfIT");
		CourseDAO courseDAO = (CourseDAO) beansCtx.getBean("courseDAO");
		
		Course webDevelopment = (Course) beansCtx.getBean("webDevelopment");
		MajorDAO majorDAO = (MajorDAO) beansCtx.getBean("majorDAO");
		Major major = (Major) beansCtx.getBean("softwareDevelopment");
		
		programmingFoundation.setId(null);
		databaseDevelopment.setId(null);
		businessAnalysis.setId(null);
		webDevelopment.setId(null);
		major.setId(null);
		courseDAO.add(programmingFoundation);
		courseDAO.add(databaseDevelopment);
		courseDAO.add(businessAnalysis);
		courseDAO.add(webDevelopment);
		
		try {
			programDAO.add(program);
			fail();
		} catch (RuntimeException ex) {
			logger.info("programDAO should not persist program with defined id");
		}
		
		// Test create (add) including many-to-many (coreCourses, electiveCourses), read (get*)
		program.setId(null);
		programDAO.add(program);
		majorDAO.add(major);
		assertTrue(programDAO.countAll() == 1);
		Program programFromDB = programDAO.getProgramByCode(program.getCode());
		assertNotNull(programFromDB);
		assertTrue(programFromDB.equals(program));
		assertTrue(programFromDB.getCoreCourses().size() == 2);
		assertTrue(programFromDB.getElectiveCourses().size() == 1);
		
		programFromDB = programDAO.getProgramById(program.getId());
		assertTrue(programFromDB.equals(program));
		
		Iterator<Course> iterator = programFromDB.getCoreCourses().iterator();
		boolean found = false;
		Course currentCourse;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (currentCourse.equals(programmingFoundation)) {
				found = true;
			}
		}
		assertTrue(found);
		
		iterator = programFromDB.getCoreCourses().iterator();
		found = false;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (currentCourse.equals(databaseDevelopment)) {
				found = true;
			}
		}
		assertTrue(found);
		
		iterator = programFromDB.getElectiveCourses().iterator();
		found = false;
		while (iterator.hasNext()) {
			currentCourse = iterator.next();
			if (currentCourse.equals(businessAnalysis)) {
				found = true;
			}
		}
		assertTrue(found);
		
		
		// Test other get methods
		List<Program> undergraduatePrograms = programDAO.getProgramsByCareer("undergraduate");
		List<Program> postgraduatePrograms = programDAO.getProgramsByCareer("postgraduate");
		assertNotNull(undergraduatePrograms);
		assertNotNull(postgraduatePrograms);
		
		int undergraduateProgramsSize = undergraduatePrograms.size();
		int postgraduateProgramsSize = postgraduatePrograms.size();
		Byte enabled = 1;
		
		Program undergraduateProgram = new Program(null,"code1","title1",enabled,"description1","undergraduate",new Integer(20),null,null);
		Program postgraduateProgram = new Program(null,"code2","title2",enabled,"description2","postgraduate",new Integer(10),null,null);
		programDAO.add(undergraduateProgram);
		programDAO.add(postgraduateProgram);
		
		undergraduatePrograms = programDAO.getProgramsByCareer("undergraduate");
		postgraduatePrograms = programDAO.getProgramsByCareer("postgraduate");
		
		assertTrue(undergraduatePrograms.size() == (undergraduateProgramsSize + 1) );
		assertTrue(postgraduatePrograms.size() == (postgraduateProgramsSize + 1) );
		
		List<Program> allPrograms = programDAO.getAllPrograms();
		assertTrue(allPrograms.size() >= 3);
		found = false;
		for(Program currentProgram: allPrograms) {
			if (currentProgram.equals(program)) {
				found = true;
			}
		}
		assertTrue(found);
		
		// Test getProgramMajors
		List<Major> majors = programDAO.getProgramMajors(program);
		assertNotNull(majors);
		assertTrue(1 == majors.size());
		assertTrue(major.equals(majors.get(0)));
		
		// Test update (save)
		program.setCode("BachIT");
		programDAO.save(program);
		programFromDB = programDAO.getProgramByCode(program.getCode());
		assertNotNull(programFromDB);
		assertTrue(programFromDB.equals(program));
		
		
		// Test delete
		majorDAO.delete(major);
		programDAO.delete(program);
		programDAO.delete(undergraduateProgram);
		programDAO.delete(postgraduateProgram);
		courseDAO.delete(programmingFoundation);
		courseDAO.delete(databaseDevelopment);
		courseDAO.delete(businessAnalysis);
		courseDAO.delete(webDevelopment);
		assertNull(majorDAO.getMajorByCode(major.getCode()));
		assertNull(courseDAO.getCourseByCode(programmingFoundation.getCode()));
		assertNull(courseDAO.getCourseByCode(databaseDevelopment.getCode()));
		assertNull(courseDAO.getCourseByCode(businessAnalysis.getCode()));
		assertNull(courseDAO.getCourseByCode(webDevelopment.getCode()));
		assertNull(programDAO.getProgramByCode(program.getCode()));
		assertTrue(programDAO.countAll() == 0);
	} // testCRUDProgram
}