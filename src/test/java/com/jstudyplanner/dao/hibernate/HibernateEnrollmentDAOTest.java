package com.jstudyplanner.dao.hibernate;

import static org.junit.Assert.assertNotNull;
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
import com.jstudyplanner.dao.EnrollmentDAO;
import com.jstudyplanner.dao.MajorDAO;
import com.jstudyplanner.dao.TermDAO;
import com.jstudyplanner.dao.UserDAO;
import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Enrollment;
import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Student;
import com.jstudyplanner.domain.Term;

public class HibernateEnrollmentDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(HibernateCampusDAOTest.class);
	private static ApplicationContext beansCtx;
	
	@BeforeClass
	public static void setUp() {
		beansCtx = new ClassPathXmlApplicationContext("test-context.xml");
	}
	
	/**
	 * This method tests all CRUD operations.
	 * DAO should not add object with defined id because id should be assigned by the database (auto-increment).
	 * This test persists Enrollment object into the database, retrieves it back, compares,
	 * deletes it from the database and checks the result.
	 * Methods tested:
	 * add(Enrollment)
	 * save(Enrollment)
	 * delete(Enrollment)
	 * delete(Long)
	 * getEnrollmentById(Long)
	 * getEnrollmentByCourseAvailabilityAndStudent(CourseAvailability, Student)
	 * getEnrollmentByCourseAvailability(CourseAvailability)
	 * getEnrollmentByStudent(Student)
	 */
	@Test
	public void testCRUDEnrollment() {
		Term term1_2012 = (Term) beansCtx.getBean("term1_2012");
		Course webDevelopment = (Course) beansCtx.getBean("webDevelopment");
		Course programmingFoundation = (Course) beansCtx.getBean("programmingFoundation");
		Campus newcastle = (Campus) beansCtx.getBean("newcastle");
		Campus ipswich = (Campus) beansCtx.getBean("ipswich");
		Major major = (Major) beansCtx.getBean("softwareDevelopment");
		CourseAvailability ca1 = (CourseAvailability) beansCtx.getBean("webDevelopment_newcastle_term1_2012");
		CourseAvailability ca2 = (CourseAvailability) beansCtx.getBean("programmingFoundation_newcastle_term1_2012");
		CourseAvailability ca3 = (CourseAvailability) beansCtx.getBean("programmingFoundation_ipswich_term1_2012");
		Student student = (Student) beansCtx.getBean("student");
		Enrollment enrollment1 = (Enrollment) beansCtx.getBean("enrollment1");
		Enrollment enrollment2 = (Enrollment) beansCtx.getBean("enrollment2");
		
		term1_2012.setId(null);
		webDevelopment.setId(null);
		programmingFoundation.setId(null);
		newcastle.setId(null);
		ipswich.setId(null);
		major.setId(null);
		ca1.setId(null);
		ca2.setId(null);
		ca3.setId(null);
		student.setId(null);
		
		TermDAO termDAO = (TermDAO) beansCtx.getBean("termDAO");
		CourseDAO courseDAO = (CourseDAO) beansCtx.getBean("courseDAO");
		CampusDAO campusDAO = (CampusDAO) beansCtx.getBean("campusDAO");
		MajorDAO majorDAO = (MajorDAO) beansCtx.getBean("majorDAO");
		CourseAvailabilityDAO caDAO = (CourseAvailabilityDAO) beansCtx.getBean("courseAvailabilityDAO");
		EnrollmentDAO enrollmentDAO = (EnrollmentDAO) beansCtx.getBean("enrollmentDAO");
		UserDAO userDAO = (UserDAO) beansCtx.getBean("userDAO");
		
		termDAO.add(term1_2012);
		courseDAO.add(programmingFoundation);
		courseDAO.add(webDevelopment);
		campusDAO.add(newcastle);
		campusDAO.add(ipswich);
		majorDAO.add(major);
		caDAO.add(ca1);
		caDAO.add(ca2);
		caDAO.add(ca3);
		userDAO.add(student);
		
		// Test create (add) and read (get*)
		try {
			enrollmentDAO.add(enrollment1);
			fail();
		} catch (RuntimeException ex) {
			logger.info("enrollmentDAO should not persist enrollment with defined id");
		}
		enrollment1.setId(null);
		enrollment2.setId(null);
		enrollmentDAO.add(enrollment1);
		enrollmentDAO.add(enrollment2);
		assertTrue(enrollmentDAO.countAll() == 2);
		Enrollment enrollmentFromDB = enrollmentDAO.getEnrollmentById(enrollment1.getId());
		assertNotNull(enrollmentFromDB);
		assertTrue(enrollmentFromDB.equals(enrollment1));
		enrollmentFromDB = enrollmentDAO.getEnrollmentByCAAndStudent(ca1, student);
		
		// Test other get methods
		List<Enrollment> enrollments = enrollmentDAO.getEnrollmentsByCA(ca1);
		assertNotNull(enrollments);
		assertTrue(enrollments.size() == 1);
		assertTrue(enrollments.get(0).equals(enrollment1));
		
		enrollments = enrollmentDAO.getEnrollmentsByStudent(student);
		assertNotNull(enrollments);
		assertTrue(enrollments.size() == 2);
		
		// Test update (save)
		enrollment1.setCourseAvailability(ca3);
		enrollmentDAO.save(enrollment1);
		enrollmentFromDB = enrollmentDAO.getEnrollmentById(enrollment1.getId());
		assertNotNull(enrollmentFromDB);
		assertTrue(enrollmentFromDB.equals(enrollment1));
		
		// Test delete
		enrollmentDAO.delete(enrollment1);
		enrollmentDAO.delete(enrollment2);
		caDAO.delete(ca1);
		caDAO.delete(ca2);
		caDAO.delete(ca3);
		userDAO.delete(student);
		majorDAO.delete(major);
		campusDAO.delete(newcastle);
		campusDAO.delete(ipswich);
		courseDAO.delete(webDevelopment);
		courseDAO.delete(programmingFoundation);
		termDAO.delete(term1_2012);
		assertTrue(enrollmentDAO.countAll() == 0);
	}
}