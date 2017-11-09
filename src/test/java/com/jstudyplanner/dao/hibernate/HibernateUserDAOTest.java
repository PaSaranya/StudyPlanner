package com.jstudyplanner.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jstudyplanner.dao.CampusDAO;
import com.jstudyplanner.dao.CourseDAO;
import com.jstudyplanner.dao.MajorDAO;
import com.jstudyplanner.dao.ProgramDAO;
import com.jstudyplanner.dao.UserDAO;
import com.jstudyplanner.domain.Admin;
import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Program;
import com.jstudyplanner.domain.Staff;
import com.jstudyplanner.domain.Student;
import com.jstudyplanner.domain.User;

public class HibernateUserDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateCampusDAOTest.class);
	private static UserDAO userDAO;
	private static ApplicationContext beansCtx;
	
	@BeforeClass
	public static void setUp() {
		beansCtx = new ClassPathXmlApplicationContext("test-context.xml");
		userDAO = (UserDAO) beansCtx.getBean("userDAO");
	}
	
	@Test
	public void testSetAndGetCampusDAO() {
		assertNotNull(userDAO);
	}
	
	/**
	 * DAO should not add object with defined id because id should be assigned
	 * by the database (auto-increment).
	 * This test persists user object into the database, retrieves it back, compares,
	 * deletes it from the database and checks the result.
	 * Methods tested:
	 * addUser(User)
	 * getUserByUsername(String)
	 * getUserByEmail(String)
	 * delete(User)
	 * delete(Long)
	 */
	@Test
	public void testAddGetDeleteSaveAdmin() {
		Admin admin = (Admin) beansCtx.getBean("admin");
		try {
			userDAO.add(admin);
			fail();
		} catch (RuntimeException ex) {
			logger.info("userDAO should not persist user with defined id");
		}
		
		userDAO.delete(6l);
		admin.setId(null);
		int numberOfAdmins = userDAO.countAll();
		userDAO.add(admin);
		assertTrue(userDAO.countAll() == numberOfAdmins + 1);
		User adminFromDB = userDAO.getUserByUsername("test.admin");
		assertNotNull(adminFromDB);
		assertTrue(admin.getUsername().equals(adminFromDB.getUsername()));
		
		// username should be case insensitive
		User userLowCase = userDAO.getUserByUsername("test.admin");
		User userMixCase = userDAO.getUserByUsername("Test.Admin");
		assertTrue(userLowCase.equals(userMixCase));
		
		// email should be case insensitive
		userLowCase = userDAO.getUserByEmail("test.admin@jstudyplanner.com");
		userMixCase = userDAO.getUserByEmail("Test.Admin@jStudyPlanner.com");
		assertTrue(userLowCase.equals(userMixCase));
		
		admin.setUsername("newAdmin");
		userDAO.save(admin);
		adminFromDB = userDAO.getUserByUsername("newAdmin");
		assertNotNull(adminFromDB);
		assertTrue( admin.getUsername().equals(adminFromDB.getUsername()) );
		assertTrue( admin.getEnabled().equals(adminFromDB.getEnabled()) );
		
		userDAO.delete(admin);
		adminFromDB = userDAO.getUserByUsername("newAdmin");
		assertNull(adminFromDB); // user should be deleted
	}
	
	/**
	 * This test tests dame methods as above for Staff user.
	 * Also tests many-to-many relationship with Campus through managedCampuses
	 * This requires persisting a campus object first.
	 */
	@Test
	public void testAddGetDeleteSaveStaff() {
		Staff staff = (Staff) beansCtx.getBean("staff");
		try {
			userDAO.add(staff);
			fail();
		} catch (RuntimeException ex) {
			logger.info("userDAO should not persist user with defined id");
		}
		
		CampusDAO campusDAO = (CampusDAO) beansCtx.getBean("campusDAO");
		Campus ipswich = (Campus) beansCtx.getBean("ipswich");
		ipswich.setId(null);
		campusDAO.add(ipswich);
		
		staff.setId(null);
		userDAO.add(staff);
		Staff staffFromDB = (Staff) userDAO.getUserByUsername("alexander.stir");
		assertNotNull(staffFromDB);
		assertTrue(staff.getUsername().equals(staffFromDB.getUsername()));
		assertTrue(!staffFromDB.getManagedCampuses().isEmpty());
		
		staff.setUsername("newStaff");
		userDAO.save(staff);
		staffFromDB = (Staff) userDAO.getUserByUsername("newStaff");
		assertNotNull(staffFromDB);
		assertTrue(staff.getUsername().equals(staffFromDB.getUsername()));
		
		userDAO.delete(staff);
		staffFromDB = (Staff) userDAO.getUserByUsername("newStaff");
		assertNull(staffFromDB); // user should be deleted
		
		campusDAO.delete(ipswich);
	}
	
	@Test
	public void testAddGetDeleteSaveStudent() {
		Course webDevelopment = (Course) beansCtx.getBean("webDevelopment");
		Course programmingFoundation = (Course) beansCtx.getBean("programmingFoundation");
		Course databaseDevelopment = (Course) beansCtx.getBean("databaseDevelopment");
		Course businessAnalysis = (Course) beansCtx.getBean("businessAnalysis");
		Major major = (Major) beansCtx.getBean("softwareDevelopment");
		Campus ipswich = (Campus) beansCtx.getBean("ipswich");
		Program bachelorOfIT = (Program) beansCtx.getBean("bachelorOfIT");
		
		CourseDAO courseDAO = (CourseDAO) beansCtx.getBean("courseDAO");
		MajorDAO majorDAO = (MajorDAO) beansCtx.getBean("majorDAO");
		CampusDAO campusDAO = (CampusDAO) beansCtx.getBean("campusDAO");
		ProgramDAO programDAO = (ProgramDAO) beansCtx.getBean("programDAO");
		
		webDevelopment.setId(null);
		programmingFoundation.setId(null);
		databaseDevelopment.setId(null);
		businessAnalysis.setId(null);
		ipswich.setId(null);
		major.setId(null);
		bachelorOfIT.setId(null);
		
		
		courseDAO.add(webDevelopment);
		courseDAO.add(programmingFoundation);
		courseDAO.add(databaseDevelopment);
		courseDAO.add(businessAnalysis);
		programDAO.add(bachelorOfIT);
		campusDAO.add(ipswich);
		majorDAO.add(major);
		
		
		Student student = (Student)  beansCtx.getBean("student");
		try {
			userDAO.add(student);
			fail();
		} catch (RuntimeException ex) {
			logger.info("userDAO should not persist user with defined id");
		}
		student.setId(null);
		userDAO.add(student);
		
		// Test create (add), read (get*)
		Student studentFromStudentDB = (Student) userDAO.getUserById(student.getId());
		assertNotNull(studentFromStudentDB);
		assertTrue(studentFromStudentDB.getType().equals(student.getType()));
		assertTrue(studentFromStudentDB.getEmail().equals(student.getEmail()));
		assertTrue(studentFromStudentDB.getMajor().getCode().equals(student.getMajor().getCode()));
		
		// Test other get methods
		studentFromStudentDB = (Student) userDAO.getUserByUsername(student.getUsername());
		assertNotNull(studentFromStudentDB);
		assertTrue(studentFromStudentDB.getEmail().equals(student.getEmail()));
		
		// Test update (save)
		student.setUsername("newStudent");
		userDAO.save(student);
		studentFromStudentDB = (Student) userDAO.getUserById(student.getId());
		assertNotNull(studentFromStudentDB);
		assertTrue(studentFromStudentDB.getEmail().equals(student.getEmail()));
		
		// Test delete
		int userCount = userDAO.countAll();
		userDAO.delete(student);
		majorDAO.delete(major);
		programDAO.delete(bachelorOfIT);
		courseDAO.delete(webDevelopment);
		courseDAO.delete(programmingFoundation);
		courseDAO.delete(databaseDevelopment);
		courseDAO.delete(businessAnalysis);
		campusDAO.delete(ipswich);
		assertTrue(campusDAO.countAll() == 0);
		assertTrue(courseDAO.countAll() == 0);
		assertTrue(majorDAO.countAll() == 0);
		assertTrue(userDAO.countAll() == userCount - 1);
	}
}