package com.jstudyplanner.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstudyplanner.dao.CampusDAO;
import com.jstudyplanner.dao.CourseAvailabilityDAO;
import com.jstudyplanner.dao.CourseDAO;
import com.jstudyplanner.dao.TermDAO;
import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Term;

public class HibernateCourseAvailabilityDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateCampusDAOTest.class);
	private static ApplicationContext beansCtx;
	
	@BeforeClass
	public static void setUp() {
		beansCtx = new ClassPathXmlApplicationContext("test-context.xml");
	}
	
	/**
	 * This method tests all CRUD operations.
	 * DAO should not add object with defined id because id should be assigned by the database (auto-increment).
	 * This test persists CourseAvailability object into the database, retrieves it back, compares,
	 * deletes it from the database and checks the result.
	 * Methods tested:
	 * add(CourseAvailability)
	 * save(CourseAvailability)
	 * delete(CourseAvailability)
	 * delete(Long)
	 * getCourseAvailabilityById(Long)
	 * getCourseAvailabilityByTerm(Term)
	 * getCourseAvailabilityByCourse(Course)
	 * getCourseAvailabilityByCampus(Campus)
	 */
	@Test
	public void testCRUDMajor() {
		Term term1_2012 = (Term) beansCtx.getBean("term1_2012");
		Term term2_2012 = (Term) beansCtx.getBean("term2_2012");
		Course programmingFoundation = (Course) beansCtx.getBean("programmingFoundation");
		Campus ipswich = (Campus) beansCtx.getBean("ipswich");
		Campus newcastle = (Campus) beansCtx.getBean("newcastle");
		CourseAvailability ca1 = (CourseAvailability) beansCtx.getBean("programmingFoundation_ipswich_term1_2012");
		CourseAvailability ca2 = (CourseAvailability) beansCtx.getBean("programmingFoundation_newcastle_term1_2012");
		CourseAvailability ca3 = (CourseAvailability) beansCtx.getBean("programmingFoundation_ipswich_term2_2012");
		
		term1_2012.setId(null);
		term2_2012.setId(null);
		programmingFoundation.setId(null);
		ipswich.setId(null);
		newcastle.setId(null);
		
		TermDAO termDAO = (TermDAO) beansCtx.getBean("termDAO");
		CourseDAO courseDAO = (CourseDAO) beansCtx.getBean("courseDAO");
		CampusDAO campusDAO = (CampusDAO) beansCtx.getBean("campusDAO");
		CourseAvailabilityDAO caDAO = (CourseAvailabilityDAO) beansCtx.getBean("courseAvailabilityDAO");
		
		// Test create (add) and read (get*)
		termDAO.add(term1_2012);
		termDAO.add(term2_2012);
		courseDAO.add(programmingFoundation);
		campusDAO.add(ipswich);
		campusDAO.add(newcastle);
		try {
			caDAO.add(ca1);
			fail();
		} catch (RuntimeException ex) {
			logger.info("courseAvailabilityDAO should not persist courseAvailability with defined id");
		}
		
		ca1.setId(null);
		ca2.setId(null);
		ca3.setId(null);
		caDAO.add(ca1);
		caDAO.add(ca2);
		caDAO.add(ca3);
		CourseAvailability ca1FromDB = caDAO.getCAByTermCourseCampus(term1_2012, programmingFoundation, ipswich);
		assertNotNull(ca1FromDB);
		assertTrue(ca1FromDB.getTerm().compare(term1_2012) == 0);
		assertTrue(ca1FromDB.getCourse().equals(programmingFoundation));
		assertTrue(ca1FromDB.getCampus().equals(ipswich));
		ca1FromDB = caDAO.getCAById(ca1FromDB.getId());
		assertNotNull(ca1FromDB);
		assertTrue(ca1FromDB.getTerm().compare(term1_2012) == 0);
		assertTrue(ca1FromDB.getCourse().equals(programmingFoundation));
		assertTrue(ca1FromDB.getCampus().equals(ipswich));
		assertTrue(caDAO.countAll() == 3);
		
		// Test other get methods
		List<CourseAvailability> caListFromDB = caDAO.getCAByCampus(ipswich);
		assertNotNull(caListFromDB);
		assertTrue(caListFromDB.size() == 2);
		assertTrue(caListFromDB.get(1).getCampus().equals(ipswich));
		
		caListFromDB = caDAO.getCAByCourse(programmingFoundation);
		assertNotNull(caListFromDB);
		assertTrue(caListFromDB.size() == 3);
		assertTrue(caListFromDB.get(1).getCourse().equals(programmingFoundation));
		
		caListFromDB = caDAO.getCAByTerm(term2_2012);
		assertNotNull(caListFromDB);
		assertTrue(caListFromDB.size() == 1);
		assertTrue(caListFromDB.get(0).getTerm().compare(term2_2012) == 0);
		
		// Test update (save)
		ca1.setCampus(newcastle);
		caDAO.save(ca1);
		ca1FromDB = caDAO.getCAById(ca1FromDB.getId());
		assertNotNull(ca1FromDB);
		assertTrue(ca1FromDB.getCampus().equals(newcastle));
		
		// Test delete
		caDAO.delete(ca1);
		caDAO.delete(ca2);
		caDAO.delete(ca3);
		campusDAO.delete(newcastle);
		campusDAO.delete(ipswich);
		courseDAO.delete(programmingFoundation);
		termDAO.delete(term1_2012);
		termDAO.delete(term2_2012);
		assertNull(caDAO.getCAByTermCourseCampus(term1_2012, programmingFoundation, newcastle));
		assertNull(campusDAO.getCampusByCode(ipswich.getCode()));
		assertNull(campusDAO.getCampusByCode(newcastle.getCode()));
		assertNull(courseDAO.getCourseByCode(programmingFoundation.getCode()));
		assertTrue(caDAO.countAll() == 0);
	}
}